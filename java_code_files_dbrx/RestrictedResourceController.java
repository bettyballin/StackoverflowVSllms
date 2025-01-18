import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RestrictedResourceController {
    private static final int MAX_USERS = 10; // Set your license limit here
    private Semaphore semaphore;

    public RestrictedResourceController() {
        this.semaphore = new Semaphore(MAX_USERS, true);
    }

    @RequestMapping("/restrictedResource")
    public String restrictedResource(HttpServletResponse response) throws InterruptedException {
        semaphore.acquire(); // Will block until a permit is available
        try {
            return processRestrictedResource(response);
        } finally {
            semaphore.release();
        }
    }

    private String processRestrictedResource(HttpServletResponse response) {
        // Your logic here to interact with the restricted resource or product...

        return "someView";
    }

    public static void main(String[] args) {
    }
}