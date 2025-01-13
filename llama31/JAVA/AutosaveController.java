import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AutosaveController {
    
    @PostMapping("/autosave")
    public ResponseEntity<String> autosave(@ModelAttribute MyForm myForm, Principal principal) {
        // Save the form data for the current user
        // You can use a database or a caching layer to store the data
        // For simplicity, let's assume we're using a HashMap to store the data
        Map<String, MyForm> autosavedForms = new HashMap<>();
        autosavedForms.put(principal.getName(), myForm);
        
        return ResponseEntity.ok("Autosaved!");
    }

    public static void main(String[] args) {
    }
}

// Assuming MyForm is a separate class
class MyForm {
    // Add fields and getters/setters as needed
}