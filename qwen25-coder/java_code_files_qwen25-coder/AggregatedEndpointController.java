import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RestController {}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RequestMapping {
    String value() default "";
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface GetMapping {
    String value() default "";
}

@RestController
@RequestMapping("/api")
public class AggregatedEndpointController {

    private ItemRepository itemRepository;
    private UserService userService;

    @GetMapping("/aggregatedDataForPage")
    public Map<String, Object> getAggregatedData() {
        // Fetch and aggregate necessary data from various repositories
        List<Item> items = itemRepository.findAll();
        UserDetails user = userService.getLoggedInUserDetails();

        Map<String, Object> response = new HashMap<>();
        response.put("items", items);
        response.put("user", user);
        return response;
    }

    public static void main(String[] args) {
    }
}

interface ItemRepository {
    List<Item> findAll();
}

interface UserService {
    UserDetails getLoggedInUserDetails();
}

class Item {}
class UserDetails {}