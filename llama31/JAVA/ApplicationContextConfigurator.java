import java.util.Properties;

import org.springframework.beans.factory.config.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextConfigurator {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("webServer.host", "example.com");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBeanFactory().registerSingleton("propertySourcesPlaceholderConfigurer",
                new PropertySourcesPlaceholderConfigurer(props));

        MyService myService = (MyService) context.getBean("myService");
    }
}