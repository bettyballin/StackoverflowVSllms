import java.lang.String;

public class MultilineStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("This is a multiline string.\n");
        sb.append("It can span multiple lines.\n");
        sb.append("No need for concatenation or escaping.\n");
        String text = sb.toString();
        System.out.println(text);
    }
}