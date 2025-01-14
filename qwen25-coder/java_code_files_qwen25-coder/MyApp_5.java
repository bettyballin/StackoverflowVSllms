import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// Application entry point
@SpringBootApplication
public class MyApp_5 {
    public static void main(String[] args) {
        SpringApplication.run(MyApp_5.class, args);
    }
}

// Simple controller returning JSON response
@RestController
@RequestMapping("/api")
public class MyController {
  
  private final MyService myService; // Auto-injected by Spring

  @Autowired
  public MyController(MyService myService) {
      this.myService = myService;
  }

  @GetMapping("/data")
  public List<MyData> getData() {
    return myService.getAll();
  }
}

// Define MyService interface
interface MyService {
    List<MyData> getAll();
}

// Define MyData class
class MyData {
    // Add fields and methods as needed
}