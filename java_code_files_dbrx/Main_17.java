import org.apache.commons.lang3.StringEscapeUtils;
public class Main_17 {
    public static void main(String[] args) {
        String unecapedStr = StringEscapeUtils.unescapeHtml("&#162;");
        System.out.println((int) unecapedStr.charAt(0)); // Prints "162" which is the ASCII code for cent symbol (¢).
    }
}