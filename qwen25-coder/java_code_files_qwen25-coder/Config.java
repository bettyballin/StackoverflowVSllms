import java.lang.String;
// Example: Using Spring Session with Redis to manage sessions in a cluster
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@EnableRedisHttpSession
public class Config {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }

    public static void main(String[] args) {
    }
}