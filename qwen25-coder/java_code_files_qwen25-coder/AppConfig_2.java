import java.lang.String;

@interface Configuration {}
@interface ComponentScan {
    String basePackages() default "";
}
@interface Service {}

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig_2 {
    // This class is a regular configuration class.
}

@Service
public class MyService {
    public void doWork() {
        System.out.println("Working...");
    }

    public static void main(String[] args) {
    }
}