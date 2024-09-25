package com.farmstory.dto;

import com.farmstory.entity.OrderItem;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {
    private int orderItemId;
    private int oNo;
    private int qty;
    private ProductDTO product;

    public OrderItem toEntity() {
        return OrderItem.builder()
                .orderItemId(orderItemId)
                .oNo(oNo)
                .qty(qty)
                .product(product.toEntity())
                .build();
    }

}
