package com.farmstory.dto;

import com.farmstory.entity.Product;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private int pNo;
    private String name;
    private String cateType;
    private int price;
    private int point;
    private int sale;
    private int delivery;
    private int stock;
    private String img1;
    private String img2;
    private String img3;
    private String etc;
    private LocalDateTime rdate;

    public Product toEntity() {
        return Product.builder()
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