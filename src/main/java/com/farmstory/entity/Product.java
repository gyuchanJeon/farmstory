package com.farmstory.entity;

import com.farmstory.dto.ProductDTO;
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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "p_no")
    private int pNo;

    @Column(name = "p_name",length = 45, nullable = false)
    private String name;

    @Column(name = "p_cateType",nullable = false)
    private String cateType;

    @Column(name = "p_price", nullable = false, columnDefinition = "DEFAULT 0")
    private int price;

    @Column(name = "p_point", nullable = false)
    private int point;

    @Column(name = "p_sale", nullable = false, columnDefinition = "DEFAULT 0")
    private int sale;

    @Column(name = "p_delivery", nullable = false, columnDefinition = "DEFAULT 0")
    private int delivery;

    @Column(name = "p_stock")
    private int stock;

    @Column(name = "p_img1")
    private String img1;

    @Column(name = "p_img2")
    private String img2;

    @Column(name = "p_img3")
    private String img3;

    @Column(name = "p_etc")
    private String etc;

    @CreationTimestamp
    @Column(name = "p_rdate")
    private LocalDateTime rdate;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .pNo(pNo)
                .name(name)
                .cateType(cateType)
                .price(price)
                .point(point)
                .sale(sale)
                .delivery(delivery)
                .stock(stock)
                .img1(img1)
                .img2(img2)
                .img3(img3)
                .etc(etc)
                .rdate(rdate)
                .build();
    }

}
