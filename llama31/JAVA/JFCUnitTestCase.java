import java.lang.String;

public class JFCUnitTestCase {
    // Example JFCUnit code
    public static void main(String[] args) {
        JFCUnitFrame frame = new JFCUnitFrame("MyApp");
        frame.findComponent("MyButton").click();
    }
}