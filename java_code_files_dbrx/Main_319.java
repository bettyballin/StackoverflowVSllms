import java.lang.String;
// This is an interface. It provides a contract for any class implementing it
interface Movable {
    void move();
}

// A class implements the "Movable" interface, essentially following its contract
class Animal implements Movable {
     public void move() { // The method defined in the interface must exist here!
         System.out.println("I am moving!");
     }
}

public class Main_319{
    public static void main(String[] args) {
        // An object is created from Animal's blueprint (class). We use the object to interact with its methods
        Animal animal = new Animal();
        animal.move();  // Output: "I am moving!"
     }
}