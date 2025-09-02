package com.app.ecom_application.service;

import com.app.ecom_application.dto.CartItemDTO;
import com.app.ecom_application.dto.CartItemRequest;
import com.app.ecom_application.dto.CartItemResponse;
import com.app.ecom_application.model.CartItem;
import com.app.ecom_application.model.Product;
import com.app.ecom_application.model.User;
import com.app.ecom_application.repository.CartItemRepository;
import com.app.ecom_application.repository.ProductRepository;
import com.app.ecom_application.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    public boolean addToCart(String userId, CartItemRequest cartItemRequest) {
        Optional<Product> productOpt = productRepository.findById(cartItemRequest.getProductId());
        if(productOpt.isEmpty()) return false;

        Product product = productOpt.get();
        if(product.getStockQuantity() < cartItemRequest.getQuantity()) {
            return false; // Not enough stock
        }

        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isEmpty()) return false;

        User user = userOpt.get();

        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);
        if(existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItemRequest.getQuantity());
            existingCartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(existingCartItem.getQuantity())));
            cartItemRepository.save(existingCartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(cartItemRequest.getQuantity());
            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(cartItemRequest.getQuantity())));
            cartItemRepository.save(cartItem);
        }
        return true;
    }

    @Transactional
    public boolean deleteItemFromCart(String userId, Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
//        if(productOpt.isEmpty()) return false;

        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
//        if(userOpt.isEmpty()) return false;

        if(productOpt.isPresent() && userOpt.isPresent()) {
            cartItemRepository.deleteByUserAndProduct(userOpt.get(), productOpt.get());
            return true;
        }

/*        userOpt.flatMap(user -> productOpt.map(product -> {
            cartItemRepository.deleteByUserAndProduct(user, product);
            return true;
        }));*/

        return false;
    }

    public Optional<CartItemResponse> fetchCartByUser(String userId) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isPresent()) {
            Optional<List<CartItem>> cartItemListOpt = cartItemRepository.findByUser(userOpt.get());
            if (cartItemListOpt.isPresent()) {
                List<CartItem> cartItemList = cartItemListOpt.get();
                CartItemResponse cartItemResponse = getCartItemResponse(cartItemList);
                return Optional.of(cartItemResponse);
            }
        }
        return Optional.empty();
    }

    public Optional<List<CartItem>> fetchCartItemByUser(String userId) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isPresent()) {
            Optional<List<CartItem>> cartItemListOpt = cartItemRepository.findByUser(userOpt.get());
            if (cartItemListOpt.isPresent()) {
                List<CartItem> cartItemList = cartItemListOpt.get();
                return Optional.of(cartItemList);
            }
        }
        return Optional.empty();
    }

    private CartItemResponse getCartItemResponse(List<CartItem> cartItemList) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        for (CartItem cartItem : cartItemList) {
            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setId(cartItem.getId());
            cartItemDTO.setProductId(cartItem.getProduct().getId());
            cartItemDTO.setPrice(cartItem.getPrice());
            cartItemDTO.setQuantity(cartItem.getQuantity());
            cartItemResponse.getCartItems().add(cartItemDTO);
        }
        return cartItemResponse;
    }

    @Transactional
    public void clearCart(String userId) {
        userRepository.findById(Long.valueOf(userId)).ifPresent(cartItemRepository::deleteByUser);
    }
}
