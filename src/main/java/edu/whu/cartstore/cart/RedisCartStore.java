package edu.whu.cartstore.cart;

/**
 * @author guanruwang
 * @date 2024/6/3$
 */
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class RedisCartStore implements ICartStore {
    private static final Logger logger = Logger.getLogger(RedisCartStore.class.getName());
    private final JedisPool jedisPool;

    public RedisCartStore(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public CompletableFuture<Void> addItemAsync(String userId, String productId, int quantity) {
        return CompletableFuture.runAsync(() -> {
            logger.info(String.format("AddItemAsync called with userId=%s, productId=%s, quantity=%d", userId, productId, quantity));

            try (Jedis jedis = jedisPool.getResource()) {
                byte[] value = jedis.get(userId.getBytes());

                CartOuterClass.Cart cart;
                if (value == null) {
                    cart = CartOuterClass.Cart.newBuilder()
                            .setUserId(userId)
                            .addItems(CartOuterClass.CartItem.newBuilder()
                                    .setProductId(productId)
                                    .setQuantity(quantity)
                                    .build())
                            .build();
                } else {
                    cart = CartOuterClass.Cart.parseFrom(value);
                    Optional<CartOuterClass.CartItem> existingItem = cart.getItemsList().stream()
                            .filter(item -> item.getProductId().equals(productId))
                            .findFirst();

                    if (existingItem.isPresent()) {
                        CartOuterClass.CartItem updatedItem = existingItem.get().toBuilder()
                                .setQuantity(existingItem.get().getQuantity() + quantity)
                                .build();
                        cart = cart.toBuilder()
                                .clearItems()
                                .addAllItems(cart.getItemsList().stream()
                                        .filter(item -> !item.getProductId().equals(productId))
                                        .toList())
                                .addItems(updatedItem)
                                .build();
                    } else {
                        cart = cart.toBuilder()
                                .addItems(CartOuterClass.CartItem.newBuilder()
                                        .setProductId(productId)
                                        .setQuantity(quantity)
                                        .build())
                                .build();
                    }
                }
                jedis.set(userId.getBytes(), cart.toByteArray());
            } catch (Exception ex) {
                throw new StatusRuntimeException(Status.FAILED_PRECONDITION.withDescription(
                        "Can't access cart storage. " + ex.getMessage()));
            }
        });
    }

    @Override
    public CompletableFuture<Void> emptyCartAsync(String userId) {
        return CompletableFuture.runAsync(() -> {
            logger.info(String.format("EmptyCartAsync called with userId=%s", userId));

            try (Jedis jedis = jedisPool.getResource()) {
                CartOuterClass.Cart cart = CartOuterClass.Cart.newBuilder().setUserId(userId).build();
                jedis.set(userId.getBytes(), cart.toByteArray());
            } catch (Exception ex) {
                throw new StatusRuntimeException(Status.FAILED_PRECONDITION.withDescription(
                        "Can't access cart storage. " + ex.getMessage()));
            }
        });
    }

    @Override
    public CompletableFuture<CartOuterClass.Cart> getCartAsync(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            logger.info(String.format("GetCartAsync called with userId=%s", userId));

            try (Jedis jedis = jedisPool.getResource()) {
                byte[] value = jedis.get(userId.getBytes());

                if (value != null) {
                    return CartOuterClass.Cart.parseFrom(value);
                }

                // Return empty cart if user wasn't in the cache before
                return CartOuterClass.Cart.newBuilder().setUserId(userId).build();
            } catch (Exception ex) {
                throw new StatusRuntimeException(Status.FAILED_PRECONDITION.withDescription(
                        "Can't access cart storage. " + ex.getMessage()));
            }
        });
    }

    @Override
    public boolean ping() {
        try (Jedis jedis = jedisPool.getResource()) {
            return "PONG".equals(jedis.ping());
        } catch (Exception ex) {
            return false;
        }
    }
}

