package com.farmstory.entity;

import com.farmstory.dto.ReceiverDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "recNick")
    private String where;

    @Column(name = "recName")
    private String name;

    @Column(name = "recHp")
    private String hp;

    @Column(name = "recZip")
    private String zip;

    @Column(name = "recAddr1")
    private String addr1;

    @Column(name = "recAddr2")
    private String addr2;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    public ReceiverDTO toDTO(){
        return ReceiverDTO.builder()
                .no(no)
                .where(this.where)
                .name(this.name)
                .hp(this.hp)
                .zip(this.zip)
                .addr1(this.addr1)
                .addr2(this.addr2)
                .user(user.toDTO())
                .build();

    }

}
