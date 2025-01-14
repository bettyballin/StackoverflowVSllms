class Vehicle {
    public static int getPrice() {
        return 20000;
    }
}

class Truck extends Vehicle {
    public static int getPrice() {
        return 30000;
    }
}

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck();
        int price = Vehicle.getPrice();  // Returns 20,000 by calling Vehicle's getPrice()
        System.out.println(price);
    }
}