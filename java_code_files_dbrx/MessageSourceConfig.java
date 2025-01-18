import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageSourceConfig {
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        // Create and configure message source
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/messages", "classpath:/messages/labels");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    public static void main(String[] args) {
    }
}