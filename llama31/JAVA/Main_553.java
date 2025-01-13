import java.util.regex.Pattern;

public class Main_553 {
    public static void main(String[] args) {
        String text = "This is a test string.\nIt has multiple lines.\r\nAnd different types of line breaks.";
        text = text.replaceAll("\\r?\\n", "<br/>");
        System.out.println(text);
    }
}