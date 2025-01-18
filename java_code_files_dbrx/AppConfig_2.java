import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig_2 {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("UTF-8");
        //This sets the basename property to whatever name you have chosen, in this case messages (note no file extension)
        source.setBasename("messages");
        return source;
    }

    public static void main(String[] args) {
    }
}