import java.lang.String;
// Example of using Spring Boot with Netflix Eureka for service discovery

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MyServiceApplication_1 {
    public static void main(String[] args) {
        SpringApplication.run(MyServiceApplication_1.class, args);
    }
}