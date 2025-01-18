import java.lang.String;
public class MyClass_53 {
  private String name;
  public MyClass_53() { // A default delegate no-arg constructor that can be left out if not needed
    this("default");
  }
  public MyClass_53(String s) { // Chains to a superclass or other constructors of the same class, setting up its own fields afterwards
    this.name = s; // Assigns value to an instance variable specific for this subtype after delegating
  }

  public static void main(String[] args) {
  }
}