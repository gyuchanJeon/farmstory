package com.farmstory.entity;

import com.farmstory.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "carts")
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(length = 50, nullable = false)
    private String uid;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(length = 50, unique = true)
    private String nick;

    @Column(length = 100, unique = true)
    private String email;

    @Column(unique = true, columnDefinition = "CHAR(13) NOT NULL")
    private String hp;

    private String zip;
    private String addr1;
    private String addr2;
    private String grade;
    private String regIp;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'USER'")
    private String role = "USER";

    @Column(nullable = false, columnDefinition = "DEFAULT 0")
    private int point;

    @CreationTimestamp
    private LocalDateTime rdate;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receiver> receivers;

    ///////////////////////////// 1안 //////////////////////////
    // 양방향 참조
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    /*///////////////////////////// 2안 //////////////////////////
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts;
    ////////////////////////////////////////////////////////////*/


    public UserDTO toDTO(){
        return UserDTO.builder()
                .uid(uid)
                .name(name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .grade(grade)
                .regIp(regIp)
                .role(role)
                .point(point)
                .rdate(rdate)
                .cart(cart.toDTO())
                .build();
    }
}
