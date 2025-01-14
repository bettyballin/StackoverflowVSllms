import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/display")
public class DisplayController {

    @GetMapping("/{colorId}")
    public ResponseEntity<String> getColorDisplay(
            @PathVariable String colorId,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String anotherParam) {
        
        // Your business logic here
        return ResponseEntity.ok("Got color ID: " + colorId + 
                                 ", Display Name: " + displayName +
                                 ", Another Param: " + anotherParam);
    }

    public static void main(String[] args) {
    }
}