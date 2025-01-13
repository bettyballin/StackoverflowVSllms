import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resources")
    public List<Resource> getResources(@RequestParam("ids") List<Long> ids) {
        // Validate and sanitize the input IDs
        // ...
        return resourceService.getResources(ids);
    }

    @PostMapping("/resources/batch")
    public List<Resource> getResources(@RequestBody IdsRequest request) {
        // Validate and sanitize the input IDs
        // ...
        return resourceService.getResources(request.getIds());
    }
}

class IdsRequest {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}

class Resource {
    // Add properties and getters/setters for the Resource class
}

class ResourceService {
    public List<Resource> getResources(List<Long> ids) {
        // Implement the logic to retrieve resources based on IDs
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // You can add code here to test the ResourceController
    }
}