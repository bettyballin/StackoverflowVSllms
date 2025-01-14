import java.lang.String;
public class Main_37 {
    public static void main(String[] args) {
        String input = "Hello, World! 123.";
        String output = removeNonAlphanumeric(input);
        System.out.println(output);  // Output: Hello World 123
    }

    public static String removeNonAlphanumeric(String str) {
        return str.replaceAll("[^a-zA-Z0-9 ]", "");
    }
}