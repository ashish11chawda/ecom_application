package com.ecommerce.order.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartItemResponse {
    List<CartItemDTO> cartItems = new ArrayList<>();
}
