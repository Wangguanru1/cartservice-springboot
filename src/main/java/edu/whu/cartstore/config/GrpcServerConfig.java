package edu.whu.cartstore.config;

/**
 * @author guanruwang
 * @date 2024/6/5$
 */

import edu.whu.cartstore.cart.ICartStore;
import edu.whu.cartstore.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GrpcServerConfig {

    @Bean
    public CartService cartService(ICartStore cartStore) {
        return new CartService(cartStore);
    }

}
