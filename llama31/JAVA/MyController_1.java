import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@RestController
public class MyController_1_1 {
    
    @Autowired
    private MyService myService;
    
    @PostMapping("/{id}")
    public ResponseEntity<?> handleRequest(@PathVariable Long id) {
        myService.doSomething(id);
        return ResponseEntity.ok().build();
    }

	public static void main(String[] args) {
	}
}