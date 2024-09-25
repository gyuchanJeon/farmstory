package com.farmstory.dto;

import com.farmstory.entity.Order;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private int oNo;
    private String uid;
    private List<OrderItemDTO> oItem;
    private LocalDateTime rdate;
    private ReceiverDTO receiver;
    private int payments;
    private String etc;
    private int delivery;
    private int totalPrice;

    public Order toEntity() {
        return Order.builder()
                .oNo(oNo)
                .rdate(rdate)
                .orderItems(oItem.stream()
                        .map(dto -> dto.toEntity())
                        .collect(Collectors.toList()))
                .payments(payments)
                .etc(etc)
                .delivery(delivery)
                .totalPrice(totalPrice)
                .build();
    }
}