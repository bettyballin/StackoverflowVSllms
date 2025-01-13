import java.lang.String;
public class Example_13 {
    public static void main(String[] args) {
        Object someObject = "Hello, World!";
        // Approach 1
        String s = someObject.toString();
        System.out.println(s);
        
        // Approach 2
        System.out.println(someObject.toString());
    }
}