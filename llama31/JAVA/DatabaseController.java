import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping
    public String writeRow(@RequestBody DatabaseRequest databaseRequest) {
        databaseService.writeRow(databaseRequest);
        return "Row written successfully";
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and won't actually start a Spring application.
        System.out.println("This is a Spring-based controller and won't function without a Spring application context.");
    }
}