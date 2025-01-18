import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:common-properties.properties")
public class MyWebApp {

    public static void main(String[] args) {
        SpringApplication.run(MyWebApp.class, args);
    }
}