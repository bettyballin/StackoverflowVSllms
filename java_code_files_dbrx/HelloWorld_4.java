import java.lang.String;
import java.util.*;
public class HelloWorld_4 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter your name");
      String userName = scan.nextLine();
      System.out.printf("Hello %s!",userName );
    }
}
