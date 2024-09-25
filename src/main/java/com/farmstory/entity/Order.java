package com.farmstory.entity;

import com.farmstory.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_no")
    private int oNo;

    @CreationTimestamp
    @Column(name ="o_rdate")
    private LocalDateTime rdate;

    @Column(name ="o_payments")
    private int payments;

    @Column(name ="o_etc")
    private String etc;

    @Column(name ="o_delivery")
    private int delivery;

    @Column(name ="o_totalPrice")
    private int totalPrice;

    @Column(name ="o_status")
    private String status;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "o_pNo")
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "o_uid")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver")
    private Receiver receiver;


    public OrderDTO toDTO(){
        return OrderDTO.builder()
                .oNo(oNo)
                .uid(user.getUid())
                .rdate(rdate)
                .payments(payments)
                .etc(etc)
                .delivery(delivery)
                .totalPrice(totalPrice)
                .receiver(receiver.toDTO())
                .oItem(orderItems.stream()
                        .map(entity -> entity.toDTO())
                        .collect(Collectors.toList()))
                .build();
    }
}
