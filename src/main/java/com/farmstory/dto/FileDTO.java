package com.farmstory.dto;

import com.farmstory.entity.File;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {

    private int fNo;
    private int aNo;
    private String oName;
    private String sName;
    private int download;
    private LocalDateTime rdate;

    public File toEntity() {
        return File.builder()
                .fNo(fNo)
                .aNo(aNo)
                .oName(oName)
                .sName(sName)
                .download(download)
                .rdate(rdate)
                .build();
    }
}