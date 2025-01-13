import org.junit.Assert;

public class WhitespaceInsensitiveAssert {
    public static void assertEquals(String expected, String actual) {
        Assert.assertEquals(expected.replaceAll("\\s+", ""), actual.replaceAll("\\s+", ""));
    }

    public static void main(String[] args) {
        assertEquals("HelloWorld", "Hello World");
    }
}