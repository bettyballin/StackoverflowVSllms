import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Parent class
@Entity
@Table(name = "VEHICLE")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// Child class
@Entity
@Table(name = "CAR")
class Car_1 extends Vehicle {
    private Integer numberOfDoors;
    // getters and setters

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}

// Child class
@Entity
@Table(name = "TRUCK")
public class Truck extends Vehicle {
    private Integer payloadCapacity;
    // getters and setters

    public Integer getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(Integer payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public static void main(String[] args) {
        // Example usage
        Truck myTruck = new Truck();
        myTruck.setColor("Blue");
        myTruck.setPayloadCapacity(2000);
        System.out.println("Truck Color: " + myTruck.getColor());
        System.out.println("Payload Capacity: " + myTruck.getPayloadCapacity());
    }
}