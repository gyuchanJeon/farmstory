package com.farmstory.dto;

import com.farmstory.entity.Receiver;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiverDTO {
    private int no;
    private String where;
    private String name;
    private String hp;
    private String zip;
    private String addr1;
    private String addr2;
    private UserDTO user;

    public Receiver toEntity() {
        return Receiver.builder()
                .no(no)
                .where(where)
                .name(name)
                .hp(hp)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .user(user.toEntity())
                .build();
    }

}
