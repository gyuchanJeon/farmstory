package com.farmstory.entity;

import com.farmstory.dto.TermsDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "terms")
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
    private int id;

    @Column(name = "term_content1", columnDefinition = "TEXT", nullable = false)
    private String content1;

    @Column(name = "term_content2", columnDefinition = "TEXT", nullable = false)
    private String content2;

    public TermsDTO toDTO(){
        return TermsDTO.builder()
                .id(this.id)
                .content1(this.content1)
                .content2(this.content2)
                .build();
    }
}
