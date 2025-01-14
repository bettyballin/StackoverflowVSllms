import java.lang.String;
class Vehicle{
  double basePrice = 20000;
  public double getPrice(){
     return basePrice;
   }
}

public class Truck extends Vehicle{
  double truckPrice = 14000;
  @Override
  public double getPrice(){ // Correctly overrides the superclass method
     return truckPrice;
   }

  public static void main(String[] args) {
  }
}