package com.farmstory.entity;

import com.farmstory.dto.CartItemDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem { // 1안

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pNo", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int qty;

    public CartItemDTO toDTO(){
        return CartItemDTO.builder()
                .id(id)
                .product(product.toDTO())
                .qty(qty)
                .build();
    }
}
