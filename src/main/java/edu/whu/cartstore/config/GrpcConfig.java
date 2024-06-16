package edu.whu.cartstore.config;

/**
 * @author guanruwang
 * @date 2024/6/5$
 */

import edu.whu.cartstore.cart.ICartStore;
import edu.whu.cartstore.cart.RedisCartStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class GrpcConfig {

//    @Value("${REDIS_ADDR}")
//    private String redisAddress;
    private String redisAddress = System.getenv("REDIS_ADDR");

    @Bean
    public ICartStore cartStore() throws Exception {
        if (!redisAddress.isEmpty()) {
            System.out.println("Creating Redis cart store");
            return new RedisCartStore(jedisPool());
        }
        return null;
    }

    @Bean
    public JedisPool jedisPool() {
        String[] redisAddressParts = redisAddress.split(":");
        String host = redisAddressParts[0];
        int port = Integer.parseInt(redisAddressParts[1]);
        return new JedisPool(new JedisPoolConfig(), host, port);
    }
}
