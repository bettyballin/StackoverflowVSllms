import javax.persistence.*;
import java.io.Serializable;

// Assuming MovementData is defined in the same package or properly imported
@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

    private int numWheels;
    private String color;
    private int id;
    private MovementData movementData;

    @Id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NUM_WHEELS")
    public int getNumWheels() {
        return this.numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    @Column(name = "COLOR")
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "speed", column = @Column(name = "SPEED")),
        @AttributeOverride(name = "timeOfPosition", column = @Column(name = "TIME_OF_POSITION")),
        @AttributeOverride(name = "longitude", column = @Column(name = "LONGITUDE")),
        @AttributeOverride(name = "latitude", column = @Column(name = "LATITUDE"))
    })
    public MovementData getMovementData() {
        return movementData;
    }

    public void setMovementData(MovementData movementData) {
        this.movementData = movementData;
    }

    public static void main(String[] args) {
        // Example usage
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setNumWheels(4);
        vehicle.setColor("Red");
        // Assuming MovementData has a constructor and is properly defined
        MovementData movementData = new MovementData();
        vehicle.setMovementData(movementData);
        // To persist or use 'vehicle', you would typically use an EntityManager.
        // This is a placeholder for your actual persistence logic.
    }
}