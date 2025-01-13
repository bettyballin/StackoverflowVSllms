import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.repository.RedisSessionRepository;
import org.springframework.session.data.redis.repository.SessionRepository;

import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@Configuration
@EnableRedisHttpSession
public class SessionConfig {
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new RedisConnectionFactory();
    }
    
    @Bean
    public SessionRepository sessionRepository() {
        return new RedisSessionRepository(redisConnectionFactory());
    }
}

@Configuration
public class MemcachedConfig {
    @Bean
    public MemcachedClient memcachedClient() {
        return new MemcachedClient();
    }
}

@RestController
public class ShoppingCartController {
    @Autowired
    private SessionRepository sessionRepository;
    
    @Autowired
    private MemcachedClient memcachedClient;
    
    @GetMapping("/cart")
    public Object getCart(HttpSession session) {
        // Retrieve session from Redis
        Session storedSession = sessionRepository.findById(session.getId());
        
        // Cache session data in Memcached
        memcachedClient.set("cart-" + session.getId(), storedSession.getAttribute("cart"));
        
        // Return shopping cart data
        return storedSession.getAttribute("cart");
    }

    public static void main(String[] args) {
    }
}

class RedisConnectionFactory {}
class RedisSessionRepository extends SessionRepository {}
class Session {}