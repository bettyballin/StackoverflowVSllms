// File: Application_2.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
public class Application_2 {

    public static void main(String[] args) {
        SpringApplication.run(Application_2.class, args);
    }
}

// File: MyService.java
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyService {
    private final EntityManager em;

    @Autowired
    public MyService(EntityManager em) {
        this.em = em;
    }

    // Service methods here
}