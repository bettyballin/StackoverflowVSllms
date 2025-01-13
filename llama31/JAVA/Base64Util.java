import java.lang.String;
import sun.misc.BASE64Encoder; // Add import statement for BASE64Encoder

public class Base64Util {
    @SuppressWarnings("restriction")
    public void yourMethod() {
        BASE64Encoder encoder = new BASE64Encoder();
        // ...
    }

    public static void main(String[] args) {
        // Create an instance of the class to avoid warning about unused method
        Base64Util util = new Base64Util();
        util.yourMethod();
    }
}