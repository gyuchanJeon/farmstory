package com.farmstory.dto;

import com.farmstory.entity.Article;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    private int aNo;
    private String group;
    private int cateNo;
    private String title;
    private String content;
    private int hit;

    private List<FileDTO> files; // 추가 필드
    private List<CommentDTO> comments; // 추가 필드

    private int file;
    private int com;

    private UserDTO writer;
    private String regip;
    private LocalDateTime rdate;

    public Article toEntity() {
        return Article.builder()
                .aNo(aNo)
                .group(group)
                .cateNo(cateNo)
                .title(title)
                .content(content)
                .hit(hit)
                .files(files.stream().map(dto->dto.toEntity()).collect(Collectors.toList()))
                .comments(comments.stream().map(dto->dto.toEntity()).collect(Collectors.toList()))
                .user(writer.toEntity())
                .regip(regip)
                .rdate(rdate)
                .build();
    }

}