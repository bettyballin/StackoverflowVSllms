// Vehicle.java
public class Vehicle {
    public static int getPrice() {
        return 10000;
    }
}

// Truck.java
public class Truck extends Vehicle {
    public static int getPrice() {
        return 14000;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck();
        System.out.println(truck.getPrice()); // Returns 14,000 because it calls the method in Truck class
        // truck.super.getPrice(); // Syntax error: Cannot use super in this context.
        System.out.println(((Vehicle) truck).getPrice()); // Calls Vehicle.getPrice() to call superclass method.
    }
}