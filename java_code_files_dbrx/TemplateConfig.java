import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

public class TemplateConfig {

    @Bean
    public SpringResourceTemplateResolver templateResolver(){

        //Creating a new SpringResourceTemplateResolver. Setting order and cacheable to true
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setOrder(1);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    public static void main(String[] args) {
    }
}