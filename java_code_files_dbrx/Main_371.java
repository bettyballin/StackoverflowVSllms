class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Truck();  // instance of child class referred to by reference variable of parent type. Here truck's getPrice() is invoked at runtime (due to polymorphism).
        System.out.println("Price from Truck: " + ((Truck)vehicle).getPrice());
    }
}
class Vehicle {
    double basePrice = 20000;
    public double getPrice()   // Base class method here
    {
        return basePrice;
    }
}
class Truck extends Vehicle  // Child class overrides the parent's version of getPrice method
{
    double truckPrice = 14000;
    public double getPrice()   // override super.getPrice() by implementing custom logic in child
    {
        return truckPrice *5;// Here we just consider some arbitrary computation on derived class specific attribute (could be any other custom logic), but base or parent version remains accessible using 'super' keyword..
    }
}