import java.lang.String;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebMvc
public class WebConfig_1 implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://your-frontend-domain.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }

    public static void main(String[] args) {
    }
}