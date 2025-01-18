import java.lang.String;
class Test {
  static{ // these blocks are executed before creating instance of a class and add up in JVM startup time
    System.out.println("static intializer block");
    }
}

public class MainTest{
  public static void main(String args[]) {
     Test t = new Test(); // creates an object of test and runs the static initializers blocks in test class
  }// end functionmain()
} // end MainTest class