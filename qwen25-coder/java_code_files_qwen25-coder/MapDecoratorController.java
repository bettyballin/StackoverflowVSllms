// Define necessary annotations
@interface RestController {
}

@interface PostMapping {
    String value();
}

@interface GetMapping {
    String value();
}

@interface RequestParam {
}

// Define necessary classes
class ResponseEntity<T> {

    public T body;
    public int status;

    public ResponseEntity(T body, int status) {
        this.body = body;
        this.status = status;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public static ResponseEntity<StringBuilder> status(int status) {
        return new ResponseEntity<>(new StringBuilder(), status);
    }

    public ResponseEntity<T> body(T body) {
        this.body = body;
        return this;
    }

    public static <T> ResponseEntity<T> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<T> build() {
        return this;
    }
}

class HttpStatus {
    public static final int OK = 200;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_FOUND = 404;
}

// Main class
@RestController
public class MapDecoratorController {

    private final MapDecoratorService mapDecoratorService;

    public MapDecoratorController() {
        this.mapDecoratorService = new MapDecoratorService();
    }

    @PostMapping("/set")
    public ResponseEntity<String> set(@RequestParam String key, @RequestParam String value) {
        try {
            mapDecoratorService.set(key, value);
            return ResponseEntity.ok("Set successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam String key) {
        String result = mapDecoratorService.get(key);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    public static void main(String[] args) {
        MapDecoratorController controller = new MapDecoratorController();
        controller.set("exampleKey", "exampleValue");
        ResponseEntity<String> response = controller.get("exampleKey");
        System.out.println("Status: " + response.status);
        System.out.println("Body: " + response.body);
    }
}

// Supporting service class
class MapDecoratorService {

    private java.util.Map<String, String> map = new java.util.HashMap<>();

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }
}