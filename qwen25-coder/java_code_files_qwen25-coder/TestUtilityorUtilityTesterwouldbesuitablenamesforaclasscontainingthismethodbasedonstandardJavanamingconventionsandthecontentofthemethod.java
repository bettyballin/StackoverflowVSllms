import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestUtility {
    @Test
    public void testParseDate() {
        String expected = "Mon Jan 15 09:26:07 PST 2001";
        String actual = Utility.parseDate("yourInput"); // Adjust as needed

        assertEquals("Date strings are not equal", expected, actual);
        
        if (!expected.equals(actual)) {
            for (int i = 0; i < Math.min(expected.length(), actual.length()); i++) {
                char eChar = expected.charAt(i);
                char aChar = actual.charAt(i);

                if (eChar != aChar) {
                    System.out.printf("Difference at index %d: '%c' vs. '%c'\n", i, eChar, aChar);
                }
            }
        }
    }
    public static void main(String[] args) {
    }
}