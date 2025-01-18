import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URISyntaxException;

@RequestMapping("/javaapi")
public class CustomDataResource {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getAllCustomData() throws IOException, URISyntaxException  {
        // Here you have your logic to read from some data, it could be a database or something else
        List<String> dataList = new ArrayList<>(); // Dummy dataList to make it compile
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    public static void main(String[] args) {
    }
}

// Dummy classes and interfaces to make the code compile
class ResponseEntity<T> {
    public ResponseEntity(T body, HttpStatus status) {
    }
}

class MediaType {
    public static final String APPLICATION_JSON_VALUE = "application/json";
}

enum HttpStatus {
    OK
}

@interface GetMapping {
    String value() default "";
    String produces() default "";
}

@interface RequestMapping {
    String value() default "";
}