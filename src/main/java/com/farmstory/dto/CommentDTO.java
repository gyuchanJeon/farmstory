package com.farmstory.dto;

import com.farmstory.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private int cNo;
    private int parent;
    private String content;
    private UserDTO writer;
    private String regip;
    private LocalDateTime rdate;

    public Comment toEntity() {
        return Comment.builder()
                .comNo(cNo)
                .aNo(parent)
                .content(content)
                .user(writer.toEntity())
                .regip(regip)
                .rdate(rdate)
                .build();
    }
}