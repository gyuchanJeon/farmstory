package com.farmstory.dto;

import com.farmstory.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String uid;
    private String password;
    private String name;
    private String nick;
    private String email;
    private String hp;
    private String zip;
    private String addr1;
    private String addr2;
    private String grade;
    private String role;
    private String regIp;
    private LocalDateTime rdate;
    private int point;

    private CartDTO cart;
    private List<ReceiverDTO> receivers;


    public User toEntity() {
        return User.builder()
                .uid(uid)
                .password(password)
                .name(name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .grade(grade)
                .role(role)
                .rdate(rdate)
                .regIp(regIp)
                .cart(cart.toEntity())
                .receivers(receivers.stream()
                        .map(dto -> dto.toEntity())
                        .collect(Collectors.toList()))
                .build();
    }
}
