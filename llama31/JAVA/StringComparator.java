import org.junit.Assert;

public class StringComparator {
    public static void main(String[] args) {
        String expected = "Hello";
        String actual = "   Hello   ";
        Assert.assertEquals(expected.trim(), actual.trim());
    }
}