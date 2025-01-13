import java.util.Properties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

// Assuming MyConfig and MyService are defined elsewhere in your codebase
public class MyConfigInitializer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("webServer.host", "example.com");

        MyConfig config = new MyConfig();
        config.setHost(props.getProperty("webServer.host"));

        ApplicationContext context = new AnnotationConfigApplicationContext(config.getClass());
        MyService myService = (MyService) context.getBean("myService");
    }
}