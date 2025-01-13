import java.lang.String;
import java.util.regex.Pattern;

public class Main_261 {
    public static void main(String[] args) {
        String input = "-this--is---a-test--";
        String output = input.replaceAll("^-+|-+$", "").replaceAll("-+", "-");
        System.out.println(output);
    }
}