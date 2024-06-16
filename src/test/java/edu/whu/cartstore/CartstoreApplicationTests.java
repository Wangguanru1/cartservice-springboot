package edu.whu.cartstore;

import edu.whu.cartstore.cart.CartOuterClass;
import edu.whu.cartstore.cart.CartServiceGrpc;
import edu.whu.cartstore.service.CartService;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CartstoreApplicationTests {

    private ManagedChannel channel;
    private CartServiceGrpc.CartServiceBlockingStub blockingStub;

    @Autowired
    private CartService cartService;

    @BeforeEach
    public void setUp() throws IOException {
        // Create an in-process server and channel
        String serverName = InProcessServerBuilder.generateName();
        channel = InProcessChannelBuilder.forName(serverName).directExecutor().build();
        blockingStub = CartServiceGrpc.newBlockingStub(channel);

        InProcessServerBuilder.forName(serverName).directExecutor()
                .addService(cartService)
                .build()
                .start();
    }

    @Test
    public void getItem_NoAddItemBefore_EmptyCartReturned() {
        String userId = UUID.randomUUID().toString();
        CartOuterClass.GetCartRequest request = CartOuterClass.GetCartRequest.newBuilder().setUserId(userId).build();
        CartOuterClass.Cart cart = blockingStub.getCart(request);

        assertNotNull(cart);
        //assertEquals(CartOuterClass.Cart.newBuilder().build(), cart);
    }

    @Test
    public void addItem_ItemExists_Updated() {
        String userId = UUID.randomUUID().toString();
        CartOuterClass.CartItem item = CartOuterClass.CartItem.newBuilder().setProductId("1").setQuantity(1).build();
        CartOuterClass.AddItemRequest request = CartOuterClass.AddItemRequest.newBuilder().setUserId(userId).setItem(item).build();

        // First add - nothing should fail
        blockingStub.addItem(request);

        // Second add of existing product - quantity should be updated
        blockingStub.addItem(request);

        CartOuterClass.GetCartRequest getCartRequest = CartOuterClass.GetCartRequest.newBuilder().setUserId(userId).build();
        CartOuterClass.Cart cart = blockingStub.getCart(getCartRequest);

        assertNotNull(cart);
        assertEquals(userId, cart.getUserId());
        assertEquals(1, cart.getItemsCount());
        System.out.println(cart);
        assertEquals(2, cart.getItems(0).getQuantity());

        // Cleanup
        blockingStub.emptyCart(CartOuterClass.EmptyCartRequest.newBuilder().setUserId(userId).build());
    }

    @Test
    public void addItem_New_Inserted() {
        String userId = UUID.randomUUID().toString();
        CartOuterClass.CartItem item = CartOuterClass.CartItem.newBuilder().setProductId("1").setQuantity(1).build();
        CartOuterClass.AddItemRequest request = CartOuterClass.AddItemRequest.newBuilder().setUserId(userId).setItem(item).build();

        // First add
        blockingStub.addItem(request);

        CartOuterClass.GetCartRequest getCartRequest = CartOuterClass.GetCartRequest.newBuilder().setUserId(userId).build();
        CartOuterClass.Cart cart = blockingStub.getCart(getCartRequest);

        assertNotNull(cart);
        assertEquals(userId, cart.getUserId());
        assertEquals(1, cart.getItemsCount());

        // Cleanup
        blockingStub.emptyCart(CartOuterClass.EmptyCartRequest.newBuilder().setUserId(userId).build());
        cart = blockingStub.getCart(getCartRequest);
        assertEquals(0, cart.getItemsCount());
    }
}
