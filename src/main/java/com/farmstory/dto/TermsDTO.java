package com.farmstory.dto;

import com.farmstory.entity.Terms;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermsDTO {
    private int id;
    private String content1;
    private String content2;

    public Terms toEntity() {
        return Terms.builder()
                .id(this.id)
                .content1(this.content1)
                .content2(this.content2)
                .build();
    }
}