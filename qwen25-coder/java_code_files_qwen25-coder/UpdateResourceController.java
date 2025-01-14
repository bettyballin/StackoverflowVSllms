import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UpdateResourceController {

    @PostMapping(value = "/updateResource", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateResource(@RequestParam Map<String, String> formData) {
        // Process the form data
        System.out.println("Form Data received: " + formData);
        
        // Your processing logic here
        
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    public static void main(String[] args) {
    }
}