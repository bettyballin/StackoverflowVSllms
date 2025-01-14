import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/data")
public class MyDataController {

    @Autowired
    private MyDataRepository myDataRepository;

    // Secure endpoint that requires the user to have 'WRITE' access
    @PostMapping("/")
    @PreAuthorize("hasAuthority('WRITE')")
    public MyData addData(@RequestBody MyData data) {
        return myDataRepository.save(data);
    }

    // Public endpoint for reading data (GET methods are usually public)
    @GetMapping("/")
    public List<MyData> getAllData() {
        return myDataRepository.findAll();
    }

    public static void main(String[] args) {
    }
}

// Define MyData class
class MyData {
    // Fields and methods
}

// Define MyDataRepository interface
interface MyDataRepository {
    MyData save(MyData data);
    List<MyData> findAll();
}