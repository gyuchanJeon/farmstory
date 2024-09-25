package com.farmstory.dto;

import com.farmstory.entity.CartItem;
import com.farmstory.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDTO { // 1안
    private Long id;
    private ProductDTO product;
    private int qty;

    public CartItem toEntity() {
        return CartItem.builder()
                .id(this.id)
                .product(this.product.toEntity())
                .qty(this.qty)
                .build();
    }
}
