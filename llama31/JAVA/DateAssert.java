import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAssert {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date expectedDate = new Date();
    Date actualDate = new Date();

    public static void main(String[] args) {
        DateAssert dateAssert = new DateAssert();
        dateAssert.testDateAssert();
    }

    public void testDateAssert() {
        assertEquals(sdf.format(expectedDate), sdf.format(actualDate));
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + " but was: " + actual);
        }
    }
}