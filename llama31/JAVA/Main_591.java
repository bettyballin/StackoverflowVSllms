import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main_591 {
    public static void main(String[] args) {
        // Assuming HelperClass has the addInline method
        HelperClass helper = new HelperClass();

        // Example initialization of imageByteArr, replace with actual source
        byte[] imageByteArr = {0x01, 0x02, 0x03}; // Replace with actual image data

        ByteArrayInputStream bais = new ByteArrayInputStream(imageByteArr);
        helper.addInline("cImage", bais);
    }
}

// Example HelperClass for demonstration
class HelperClass {
    public void addInline(String name, InputStream resource) {
        // Logic to add the resource inline
        System.out.println("Added " + name + " as an inline resource.");
        // Implement actual logic here
    }
}