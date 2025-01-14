// Imports
import java.io.Serializable;

// Annotations (minimal definitions)
@interface Entity {}

@interface Table {
    String name();
}

@interface Column {
    String name();
}

// Vehicle class (minimal definition)
class Vehicle {
    // Empty class
}

// Main Car class
@Entity
@Table(name = "CAR")
public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "MAKE")
    private String make;

    protected Car() {
        // Default constructor
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}