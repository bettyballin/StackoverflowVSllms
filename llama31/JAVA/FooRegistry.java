import java.lang.String;

public class FooRegistry {
    static {
        //this code must only ever be called once
        addController(new FooControllerImpl());
    }

    private static void addController(IFooController controller) {
        // ...
    }

    public static void main(String[] args) {
    }
}

// Assuming IFooController and FooControllerImpl are defined elsewhere
interface IFooController {}

class FooControllerImpl implements IFooController {}