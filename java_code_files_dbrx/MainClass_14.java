import java.lang.String;
public class MainClass_14 {
  public static void main(String[] args) {
    String str = null; // no error/warning here (compile time), but will throw NullPointerException at runtime if not handled.
    System.out.println(str.length());
  }
}