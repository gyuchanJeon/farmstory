package com.farmstory.entity;

import com.farmstory.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_no")
    private int comNo;

    @Column(name = "c_parent", nullable = false)
    private int aNo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "c_regip", nullable = false)
    private String regip;

    @CreationTimestamp
    @Column(name = "c_rdate")
    private LocalDateTime rdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_writer", nullable = false)
    private User user;

    public CommentDTO toDTO(){
        return CommentDTO.builder()
                .cNo(comNo)
                .parent(aNo)
                .content(content)
                .regip(regip)
                .rdate(rdate)
                .writer(user.toDTO())
                .build();
    }
}
