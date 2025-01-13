// Define the Vehicle class
public class Vehicle_2 {
    double basePrice = 20000;
    public double getPrice() {
        return basePrice;
    }
}

// Define the Truck class that extends Vehicle
public class Truck extends Vehicle {
    double truckPrice = 14000;
    @Override
    public double getPrice() {
        return truckPrice;
    }

    public static void main(String[] args) {
        // Create an instance of Truck and call the getPrice method
        Truck truck = new Truck();
        System.out.println("Truck price: " + truck.getPrice());
    }
}