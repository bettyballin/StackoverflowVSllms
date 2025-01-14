import java.lang.String;
public class Printer {

    static Object someObject = new Object();

    static {
        System.out.println(someObject.toString());
    }

    public static void main(String[] args) {
    }
}