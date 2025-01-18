public class YourResponseType {
    // define fields and methods as required
}

@interface RestController {
}

@interface GetMapping {
    String value();
}

@interface PathVariable {
    String value();
}

class ResponseEntity<T> {
    // define as needed
}

@RestController
public class ColorDisplayNameController {

    @GetMapping("/ColorDisplayName/{colorId}")
    public ResponseEntity<YourResponseType> getColor(@PathVariable("colorId") Long colorId) {
        // logic for fetching color details goes here.
        return null;
    }

    public static void main(String[] args) {
    }
}