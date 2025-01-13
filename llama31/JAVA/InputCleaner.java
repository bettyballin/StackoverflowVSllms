import java.lang.String;

public class InputCleaner {
    public static void main(String[] args) {
        String input = "Hello, World!"; // example input
        String cleanInput = input.replaceAll("\\P{L}+", "");
        System.out.println(cleanInput);
    }
}