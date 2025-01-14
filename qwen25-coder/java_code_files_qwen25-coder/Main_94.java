import java.lang.String;
// Define an interface (contract)
interface Vehicle {
    void start();
}

// Implementing class
class Car implements Vehicle {
    public void start() {
        System.out.println("Car engine started.");
    }
}

// Creating an object from the class
public class Main_94 {
    public static void main(String[] args) {
        Vehicle myCar = new Car();  // 'myCar' is an object of type Car, implementing the Vehicle interface
        myCar.start();
    }
}