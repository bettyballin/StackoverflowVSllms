import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.MultiValueMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class FormController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        // Create form state object and serialize it to JSON or another format
        Map<String, Object> formState = new HashMap<>();
        String serializedFormState = encodeDataToJson(formState);

        model.addAttribute("serializedFormState", serializedFormState);
        return "formPage";
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam("formState") String serializedFormState,
                               @RequestBody MultiValueMap<String, String> formData, Model model) {
        // Deserialize the form state from hidden field if needed
        Map<String, Object> formState = decodeDataFromJson(serializedFormState);

        // Process the new data and update the form state if necessary
        updateFormData(formData, formState);

        // You can then either return a redirect or render the same page with updated serializedFormState

        String updatedSerializedFormState = encodeDataToJson(formState);
        model.addAttribute("serializedFormState", updatedSerializedFormState);
        return "formPage";
    }

    private String encodeDataToJson(Map<String, Object> data) {
        // Implement JSON encoding method
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize form state", e);
        }
    }

    private Map<String, Object> decodeDataFromJson(String jsonData) {
        // Implement JSON decoding method
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonData, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize form state", e);
        }
    }

    private void updateFormData(MultiValueMap<String, String> formData, Map<String, Object> formState) {
        // Update your formState map with the received data
        for (String key : formData.keySet()) {
            formState.put(key, formData.getFirst(key));
        }
    }

    public static void main(String[] args) {
    }
}