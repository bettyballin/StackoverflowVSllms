import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

// Spring MVC configuration
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class WebConfig extends WebMvcConfigurerAdapter {
  
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions("/WEB-INF/tiles.xml");
    return configurer;
  }
  
  @Bean
  public ViewResolver viewResolver() {
    return new TilesViewResolver();
  }

	public static void main(String[] args) {
	}
}