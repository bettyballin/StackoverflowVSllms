@RestController
public class FooController {
    @PostMapping("/api/foos")
    public void create(@RequestBody Foo foo) {
        // Normalization and persistence logic here
    }

    public static void main(String[] args) {
    }
}

// Define annotations
@interface RestController { }

@interface PostMapping {
    String value();
}

@interface RequestBody { }

// Define class Foo
class Foo {
    // Empty class definition
}