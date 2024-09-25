package com.farmstory.entity;

import com.farmstory.dto.ArticleDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"file", "comment"})
@Builder
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_no")
    private int aNo;

    @Column(name = "a_group")
    private String group;

    @Column(name = "a_cateNo")
    private int cateNo;

    @Column(name = "a_title")
    private String title;

    @Column(name = "a_content", columnDefinition = "TEXT NOT NULL")
    private String content;

    @Column(name = "a_file")
    private int file;

    @Column(name = "a_hit")
    private int hit;

    @Column(name = "a_com")
    private int com;

    @Column(name = "a_regip")
    private String regip;

    @CreationTimestamp
    @Column(name = "a_rdate")
    private LocalDateTime rdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_writer")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "file")
    private List<File> files;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "com")
    private List<Comment> comments;


    public ArticleDTO toDTO() {
        return ArticleDTO.builder()
                .aNo(aNo)
                .group(group)
                .cateNo(cateNo)
                .title(title)
                .content(content)
                .file(files.size())
                .hit(hit)
                .com(comments.size())
                .regip(regip)
                .rdate(rdate)
                .writer(user.toDTO())
                .build();
    }

}
