package com.farmstory.entity;

import com.farmstory.dto.CartDTO;
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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_no")
    private int cartNo;

    @CreationTimestamp
    @Column(name = "cart_date")
    private LocalDateTime rdate;


    ///////////////////////////// 1안 //////////////////////////

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_uid",nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItems;

    // 카트에 상품 추가
    public void addProduct(Product product, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(product)) {
                cartItem.setQty(cartItem.getQty() + quantity);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQty(quantity);
        cartItems.add(cartItem);
    }

    // 카트에서 상품 제거
    public void removeProduct(Product product) {
        cartItems.removeIf(ci -> ci.getProduct().equals(product));
    }


    /*///////////////////////////// 2안 //////////////////////////

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ElementCollection
    @CollectionTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> cartItems = new HashMap<>();

     /////////////////////////////////////////////////////////*/


    public CartDTO toDTO(){
        return CartDTO.builder()
                .cartNo(cartNo)
                .cartDate(rdate)
                .cartUser(user.toDTO())
                .cartItems(cartItems.stream()
                        .map(entity -> entity.toDTO())
                        .collect(Collectors.toList()))
                .build();
    }
}
