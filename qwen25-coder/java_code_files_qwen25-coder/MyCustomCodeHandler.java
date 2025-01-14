import java.util.HashMap;
import java.util.Map;

// Step 1: Define a strategy interface
public interface ProductHandler {
    void execute(CustomerProduct product);
}

// Step 2: Create concrete classes for each action
public class MyCustomCodeHandler implements ProductHandler {
    @Override
    public void execute(CustomerProduct product) {
        // Custom implementation here, e.g., checking customer status on another DB
    }
}

// Step 3: Create a factory to map handler names to instances
public class HandlerFactory {
    private static final Map<String, ProductHandler> handlers = new HashMap<>();

    static {
        handlers.put("MyCustomCodeHandler", new MyCustomCodeHandler());
        // Register other handlers here
    }

    public static ProductHandler getHandler(String name) {
        return handlers.get(name);
    }
}

// Step 4: Use in the application logic
public class MainApplication {

    public void processCustomerProduct(CustomerProduct product) {
        String handlerName = product.getHandlerName();
        ProductHandler handler = HandlerFactory.getHandler(handlerName);

        if (handler != null) {
            handler.execute(product);
        } else {
            throw new IllegalArgumentException("No handler found for " + handlerName);
        }
    }

    public static void main(String[] args) {
        // Example usage
        CustomerProduct product = new CustomerProduct("MyCustomCodeHandler");
        MainApplication app = new MainApplication();
        app.processCustomerProduct(product);
    }
}

// Additional class needed to compile
class CustomerProduct {
    private String handlerName;

    public CustomerProduct(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerName() {
        return handlerName;
    }
}