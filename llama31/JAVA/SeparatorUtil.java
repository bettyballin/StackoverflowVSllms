import java.lang.String;

public class SeparatorUtil {
    String lineSeparator = System.getProperty("line.separator");
    char listSeparator = lineSeparator.charAt(0);

    public static void main(String[] args) {
        SeparatorUtil util = new SeparatorUtil();
        // You can use util here
    }
}