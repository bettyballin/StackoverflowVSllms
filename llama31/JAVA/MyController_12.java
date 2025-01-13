import java.util.concurrent.Semaphore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController_12_12 {
    private final Semaphore semaphore;

    public MyController_12(int licenses) {
        this.semaphore = new Semaphore(licenses);
    }

    @RequestMapping("/accessProduct")
    public String accessProduct() throws InterruptedException {
        semaphore.acquire();
        try {
            // Call the product API here
            return "Product accessed successfully";
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyController_12 and start a web server to test the controller
        // For example, using Spring Boot:
        // SpringApplication.run(MyController_12.class, args);
    }
}