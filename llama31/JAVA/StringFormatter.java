import java.lang.String;

public class StringFormatter {
    public static void main(String[] args) {
        String userInput = "John";
        String formattedString = String.format("Hello, %s!", userInput);
        System.out.println(formattedString);
    }
}