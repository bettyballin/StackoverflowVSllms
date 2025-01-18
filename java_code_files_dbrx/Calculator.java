import java.lang.String;
import static org.junit.Assert.*;
import org.junit.Test;
public class Calculator {
    // ... code of the class under review
    public int addNumbers(int a, int b) {
        return a + b;
    }
    @Test
    public void testAddition(){
        assertEquals(260, new Calculator().addNumbers(150, 110));
    }
    public static void main(String[] args) {
    }
}