import java.lang.String;
// MyUtils.java
public class MyUtils {
  public static void funcA() {
    System.out.println("Func A called");
  }

  public static void funcB() {
    funcA();
  }

	public static void main(String[] args) {
	}
}