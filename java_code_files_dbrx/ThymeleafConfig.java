import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

public class ThymeleafConfig {

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine()); // setting above spring template resolver bean to this ViewResolver
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    public SpringTemplateEngine templateEngine() {
        return new SpringTemplateEngine();
    }

    public static void main(String[] args) {
    }
}