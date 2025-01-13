import java.lang.String;

// Product interface
interface Vehicle {
    void drive();
}

// Concrete products
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Truck implements Vehicle {
    public void drive() {
        System.out.println("Driving a truck");
    }
}

// Factory class
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("car");
        vehicle.drive(); // Output: Driving a car
    }
}