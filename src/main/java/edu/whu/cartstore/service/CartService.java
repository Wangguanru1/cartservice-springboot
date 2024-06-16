package edu.whu.cartstore.service;

/**
 * @author guanruwang
 * @date 2024/6/3$
 */

import com.google.protobuf.Empty;
import edu.whu.cartstore.cart.CartOuterClass;
import edu.whu.cartstore.cart.CartServiceGrpc;
import edu.whu.cartstore.cart.ICartStore;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;


@GRpcService
public class CartService extends CartServiceGrpc.CartServiceImplBase {
    private static final Empty EMPTY = Empty.newBuilder().build();
    private final ICartStore cartStore;

    public CartService(ICartStore cartStore) {
        this.cartStore = cartStore;
    }

    @Override
    public void addItem(CartOuterClass.AddItemRequest request, StreamObserver<CartOuterClass.Empty> responseObserver) {
        cartStore.addItemAsync(request.getUserId(), request.getItem().getProductId(), request.getItem().getQuantity())
                .thenAccept(result -> {
                    responseObserver.onNext(CartOuterClass.Empty.newBuilder().build());
                    responseObserver.onCompleted();
                })
                .exceptionally(throwable -> {
                    responseObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
                    return null;
                });
    }

    @Override
    public void getCart(CartOuterClass.GetCartRequest request, StreamObserver<CartOuterClass.Cart> responseObserver) {
        cartStore.getCartAsync(request.getUserId())
                .thenAccept(cart -> {
                    responseObserver.onNext(cart);
                    responseObserver.onCompleted();
                })
                .exceptionally(throwable -> {
                    responseObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
                    return null;
                });
    }

    @Override
    public void emptyCart(CartOuterClass.EmptyCartRequest request, StreamObserver<CartOuterClass.Empty> responseObserver) {
        cartStore.emptyCartAsync(request.getUserId())
                .thenAccept(result -> {
                    responseObserver.onNext(CartOuterClass.Empty.newBuilder().build());
                    responseObserver.onCompleted();
                })
                .exceptionally(throwable -> {
                    responseObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
                    return null;
                });
    }
}
