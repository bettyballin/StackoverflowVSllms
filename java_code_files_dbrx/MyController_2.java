import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@Controller
public class MyController_2 {
    private final DomainObjectService service;

    @Autowired
    public MyController_2(DomainObjectService service) {
        this.service = service;
    }

    @RequestMapping("/path/{id}")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.processById(id));
    }

    public static void main(String[] args) {
    }
}