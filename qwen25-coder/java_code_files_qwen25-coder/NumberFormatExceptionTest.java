import java.lang.String;
public class NumberFormatExceptionTest {
    String str = "hello";
    public NumberFormatExceptionTest() {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to double: " + str);
        }
    }
    public static void main(String[] args) {
        new NumberFormatExceptionTest();
    }
}