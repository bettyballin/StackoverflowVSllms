import java.lang.String;

public class UnicodeTester {
    String testString = "\u00C3\u00BC\u00C3\u00B6\u00C3\u00BC"; // äöü

    public static void main(String[] args) {
        UnicodeTester tester = new UnicodeTester();
        System.out.println(tester.testString);
    }
}