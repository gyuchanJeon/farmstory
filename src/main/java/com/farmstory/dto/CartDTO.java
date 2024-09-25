package com.farmstory.dto;

import com.farmstory.entity.Cart;
import com.farmstory.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private int cartNo;
    private UserDTO cartUser;
    private List<CartItemDTO> cartItems;
    private LocalDateTime cartDate;

    public Cart toEntity() {
        return Cart.builder()
                .cartNo(cartNo)
                .cartItems(cartItems.stream().map(dto->dto.toEntity()).collect(Collectors.toList()))
                .user(cartUser.toEntity())
                .rdate(cartDate)
                .build();
    }

}
