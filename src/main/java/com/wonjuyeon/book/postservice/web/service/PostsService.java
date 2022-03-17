package com.wonjuyeon.book.postservice.web.service;

import com.wonjuyeon.book.postservice.domain.posts.Posts;
import com.wonjuyeon.book.postservice.domain.posts.PostsRepository;
import com.wonjuyeon.book.postservice.web.dto.PostsResponseDto;
import com.wonjuyeon.book.postservice.web.dto.PostsSaveRequestDto;
import com.wonjuyeon.book.postservice.web.dto.PostsUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public List<Posts> findAll(){
        return postsRepository.findAll();
    }

    public List<PostsResponseDto> findAllDto(){
        return postsRepository.findAll().stream()
                .map(posts -> new PostsResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        Posts save = postsRepository.save(dto.toEntity());
        return save.getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateDto dto){
        Posts post = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 글이 없습니다. id = " + id)
        );

        post.update(dto.getTitle(), dto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 없습니다. id = " + id)
        );
        return new PostsResponseDto(post);
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 없습니다. +id = " + id)
        );

        postsRepository.delete(post);
    }

}
