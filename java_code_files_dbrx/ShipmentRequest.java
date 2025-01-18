import java.lang.String;
interface Identifiable<T> {
    T getId(); // Getter method for ID property
}

// Example domain class
public class ShipmentRequest implements Identifiable<Long> {
    private Long requestId;

    public Long getId() { return this.requestId; }

    // other properties and methods related to the domain...

    public static void main(String[] args) {
    }
}