package com.farmstory.entity;

import com.farmstory.dto.FileDTO;
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
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_no")
    private int fNo;

    @Column(name = "a_no", nullable = false)
    private int aNo;

    @Column(name="f_oName", nullable = false)
    private String oName;

    @Column(name="f_sName", nullable = false)
    private String sName;

    @Column(name="f_download", columnDefinition = "DEFAULT 0", nullable = false)
    private int download;

    @CreationTimestamp
    @Column(name="f_rdate")
    private LocalDateTime rdate;

    public FileDTO toEntity() {
        return FileDTO.builder()
                .fNo(fNo)
                .aNo(aNo)
                .oName(oName)
                .sName(sName)
                .download(download)
                .rdate(rdate)
                .build();
    }


}
