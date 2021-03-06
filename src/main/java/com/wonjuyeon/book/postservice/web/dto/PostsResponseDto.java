package com.wonjuyeon.book.postservice.web.dto;

import com.wonjuyeon.book.postservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
