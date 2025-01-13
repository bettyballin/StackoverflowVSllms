import java.lang.String;
public class Main_658 {
    public static void main(String[] args) {
        String x = "Hello, World!";
        char c = 'o';
        
        if (x.indexOf(c) != -1) {
            System.out.println("Character '" + c + "' appears in the string.");
        } else {
            System.out.println("Character '" + c + "' does not appear in the string.");
        }
    }
}