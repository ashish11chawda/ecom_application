package com.app.ecom_application.dto;

import com.app.ecom_application.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
