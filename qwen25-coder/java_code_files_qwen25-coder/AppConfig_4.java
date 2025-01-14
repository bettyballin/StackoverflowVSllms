import java.lang.String;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class AppConfig_4 {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig()  {
        return new PropertySourcesPlaceholderConfigurer();
    }

	public static void main(String[] args) {
	}
}