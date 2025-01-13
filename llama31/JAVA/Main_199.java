import java.lang.String;
public class Main_199 {
    public static void main(String[] args) {
        String input = "<Hello>";
        String escaped = input.replace("<", "&lt;").replace(">", "&gt;");
        System.out.println(escaped); // prints "&lt;Hello&gt;"
    }
}