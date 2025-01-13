import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance-check")
public class InsuranceCheckController {
    @PostMapping
    public String checkInsurance(@RequestParam("insuranceNumber") String insuranceNumber) {
        // Call the existing JSP page's logic to check the insurance number
        // ...
        return "Valid"; // or "Invalid";
    }
}