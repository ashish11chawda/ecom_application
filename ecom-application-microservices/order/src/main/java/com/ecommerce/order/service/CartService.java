package com.ecommerce.order.service;

import com.ecommerce.order.dto.CartItemDTO;
import com.ecommerce.order.dto.CartItemRequest;
import com.ecommerce.order.dto.CartItemResponse;
import com.ecommerce.order.model.CartItem;
import com.ecommerce.order.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;
    public boolean addToCart(String userId, CartItemRequest cartItemRequest) {
/*        Optional<Product> productOpt = productRepository.findById(cartItemRequest.getProductId());
        if(productOpt.isEmpty()) return false;

        Product product = productOpt.get();
        if(product.getStockQuantity() < cartItemRequest.getQuantity()) {
            return false; // Not enough stock
        }

        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isEmpty()) return false;

        User user = userOpt.get();*/

        CartItem existingCartItem = cartItemRepository.findByUserIdAndProductId(Long.valueOf(userId), cartItemRequest.getProductId());
        if(existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItemRequest.getQuantity());
//            existingCartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(existingCartItem.getQuantity())));
            // FIXME: Hardcoded price, need to fetch product price
            existingCartItem.setPrice(BigDecimal.valueOf(1000.0));
            cartItemRepository.save(existingCartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setUserId(Long.valueOf(userId));
            cartItem.setProductId(cartItemRequest.getProductId());
            cartItem.setQuantity(cartItemRequest.getQuantity());
//            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(cartItemRequest.getQuantity())));
            cartItem.setPrice(BigDecimal.valueOf(1000.0 * cartItemRequest.getQuantity())); // FIXME: Hardcoded price, need to fetch product price
            cartItemRepository.save(cartItem);

        }
        return true;
    }

    @Transactional
    public boolean deleteItemFromCart(String userId, Long productId) {
//        Optional<Product> productOpt = productRepository.findById(productId);
//        if(productOpt.isEmpty()) return false;

//        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
//        if(userOpt.isEmpty()) return false;

        CartItem existingCartItem = cartItemRepository.findByUserIdAndProductId(Long.valueOf(userId), productId);
        if(existingCartItem != null) {
            cartItemRepository.delete(existingCartItem);
            return true;
        }

/*        userOpt.flatMap(user -> productOpt.map(product -> {
            cartItemRepository.deleteByUserAndProduct(user, product);
            return true;
        }));*/

        return false;
    }

    public Optional<CartItemResponse> fetchCartByUser(String userId) {
        /*Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isPresent()) {
            Optional<List<CartItem>> cartItemListOpt = cartItemRepository.findByUserId(userOpt.get());
            if (cartItemListOpt.isPresent()) {
                List<CartItem> cartItemList = cartItemListOpt.get();
                CartItemResponse cartItemResponse = getCartItemResponse(cartItemList);
                return Optional.of(cartItemResponse);
            }
        }
        return Optional.empty();*/
//        return fetchCartItemByUser(userId).map(this::getCartItemResponse);
        return cartItemRepository.findByUserId(Long.valueOf(userId))
                .map(this::getCartItemResponse);
    }

    public Optional<List<CartItem>> fetchCartItemByUser(String userId) {
/*        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isPresent()) {
            Optional<List<CartItem>> cartItemListOpt = cartItemRepository.findByUserId(userOpt.get());
            if (cartItemListOpt.isPresent()) {
                List<CartItem> cartItemList = cartItemListOpt.get();
                return Optional.of(cartItemList);
            }
        }
        return Optional.empty();*/
        return cartItemRepository.findByUserId(Long.valueOf(userId));
    }

    private CartItemResponse getCartItemResponse(List<CartItem> cartItemList) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        for (CartItem cartItem : cartItemList) {
            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setId(cartItem.getId());
            cartItemDTO.setProductId(cartItem.getProductId());
            cartItemDTO.setPrice(cartItem.getPrice());
            cartItemDTO.setQuantity(cartItem.getQuantity());
            cartItemResponse.getCartItems().add(cartItemDTO);
        }
        return cartItemResponse;
    }

    @Transactional
    public void clearCart(String userId) {
        cartItemRepository.deleteByUserId(Long.valueOf(userId));
    }
}
