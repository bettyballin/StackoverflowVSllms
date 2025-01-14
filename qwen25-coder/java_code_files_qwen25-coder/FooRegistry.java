import java.lang.String;
public class FooRegistry {

    static class FooRegistry {

        static {
            // this code must only ever be called once
            addController(new FooControllerImpl());
        }

        private static void addController(IFooController controller) {
            // ...
        }
    }

    public static void main(String[] args) {
    }
}

interface IFooController {
    // Interface definition
}

class FooControllerImpl implements IFooController {
    // Implementation
}