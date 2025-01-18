interface FooController {
    // Interface methods (if any)
}

class FooControllerImpl implements FooController {
    // Implementation of FooController methods (if any)
}

public class Fooregistry {

    static {
        // this code must only ever be called once
        addController(new FooControllerImpl());
    }

    private static void addController(FooController controller) {
        /* ... */
    }

    public static void main(String[] args) {
        // Entry point of the program
    }
}