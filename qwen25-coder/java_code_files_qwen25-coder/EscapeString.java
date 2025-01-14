import java.lang.String;
public class EscapeString {
    public static void main(String[] args) {
        String input = "79827349837493827498";
        String output = input.replaceAll("(\\w{1})(\\w{1})", "\\\\$1\\\\$2");
        System.out.println(output);
    }
}