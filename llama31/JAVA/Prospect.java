// Define the base Person class
public abstract class Person {
  // shared properties and methods
}

// Define the User interface
interface User {
  // user-specific properties and methods
  void someUserMethod(); // we need at least one method in an interface
}

// Define the Prospect class that sometimes extends User
class Prospect extends Person implements User {
  // prospect-specific properties and methods
  @Override
  public void someUserMethod() {
    System.out.println("Some user method");
  }
}

public class Main {
  public static void main(String[] args) {
    // Create a new Prospect instance that extends User
    Prospect userProspect = new Prospect();
    userProspect.someUserMethod();

    // Create a new Prospect instance that doesn't extend User
    Prospect nonUserProspect = new Prospect() {
      // override the User methods to do nothing
      @Override
      public void someUserMethod() {
        // do nothing
      }
    };
  }
}