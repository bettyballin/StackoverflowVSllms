package com.example;

public class Vehicle {
    private int wheels; // Only accessible within the Vehicle class

    int modelYear; // Accessible only within the com.example package (package-private)

    protected String type; // Accessible to subclasses even outside of this package

    public void start() { // Accessible from any other class
        System.out.println("Starting vehicle");
    }
}

class Car extends Vehicle {
    public void driveCar() {
        start(); // Public access
        type = "Sedan"; // Protected, can be accessed here
        // modelYear can also be accessed as it's in the same package
        // wheels cannot be accessed directly due to private modifier
        System.out.println("Driving " + type);
    }

    public static void main(String[] args) {
    }
}