package edu.whu.cartstore.cart;

import java.util.concurrent.CompletableFuture;

public interface ICartStore {
    CompletableFuture<Void> addItemAsync(String userId, String productId, int quantity);
    CompletableFuture<Void> emptyCartAsync(String userId);
    CompletableFuture<CartOuterClass.Cart> getCartAsync(String userId);
    boolean ping();
}
