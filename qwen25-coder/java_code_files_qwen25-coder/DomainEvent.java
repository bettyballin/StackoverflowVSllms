import java.util.Set;
import java.util.HashSet;

class DomainEvent {
    private String type;
    private String details;

    public DomainEvent(String type, String details) {
        this.type = type;
        this.details = details;
    }

    // getters and setters
    public String getType() {
        return type;
    }
    public String getDetails() {
        return details;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}

// Event Publisher using Pub/Sub pattern
interface EventPublisher {
    void publish(DomainEvent event);
}

// Simple in-memory publisher (for demonstration)
class SimpleEventPublisher implements EventPublisher {
    private final Set<EventHandler> subscribers = new HashSet<>();

    @Override
    public void publish(DomainEvent event) {
        for (EventHandler subscriber : subscribers) {
            subscriber.handle(event);
        }
    }

    public void subscribe(EventHandler handler) {
        subscribers.add(handler);
    }
}

// Event Handler Interface
interface EventHandler {
    void handle(DomainEvent event);
}

// Example usage in a Domain Service
class ProductService {
    private final EventPublisher publisher;

    public ProductService(EventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createProduct(String productId, String name) {
        // Business logic to create product...

        // Emit an event after the business logic is complete
        DomainEvent event = new DomainEvent("ProductCreated", "Product with ID: " + productId);
        publisher.publish(event);
    }
}

// Example of registering a handler
public class ProductEventHandler implements EventHandler {
    @Override
    public void handle(DomainEvent event) {
        if ("ProductCreated".equals(event.getType())) {
            // Handle the product created event (e.g., logging, notifications)
            System.out.println("Handled event: " + event.getType() + " with details: " + event.getDetails());
        }
    }

    public static void main(String[] args) {
        SimpleEventPublisher publisher = new SimpleEventPublisher();
        ProductEventHandler handler = new ProductEventHandler();

        ProductService productService = new ProductService(publisher);

        // Subscribe to events
        publisher.subscribe(handler);

        // Create a product which triggers the event mechanism
        productService.createProduct("PID-123", "Sample Product");
    }
}