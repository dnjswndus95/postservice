package com.wonjuyeon.book.postservice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateDto {

    private String title;
    private String content;

    @Builder
    public PostsUpdateDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
