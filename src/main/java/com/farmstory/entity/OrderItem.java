package com.farmstory.entity;

import com.farmstory.dto.OrderItemDTO;
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
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private int oNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    private int qty;

    public OrderItemDTO toDTO() {
        return OrderItemDTO.builder()
                .orderItemId(orderItemId)
                .oNo(oNo)
                .qty(qty)
                .product(product.toDTO())
                .build();
    }

}
