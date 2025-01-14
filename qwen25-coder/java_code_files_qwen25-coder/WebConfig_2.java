import java.lang.String;

@Configuration
public class WebConfig_2 implements WebMvcConfigurer {

   @Bean
   public TilesConfigurer tilesConfigurer() {
       final var configurer = new TilesConfigurer();
       configurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
       return configurer;
   }

   @Bean
   public ViewResolver viewResolver() {
       UrlBasedViewResolver resolver = new UrlBasedViewResolver();
       resolver.setViewClass(TilesView.class);
       return resolver;
   }

   public static void main(String[] args) {
   }

}

@interface Configuration {
}

@interface Bean {
}

interface WebMvcConfigurer {
}

class TilesConfigurer {
    public void setDefinitions(String[] definitions) {
    }
}

interface ViewResolver {
}

class UrlBasedViewResolver implements ViewResolver {
    public void setViewClass(Class<?> viewClass) {
    }
}

class TilesView {
}