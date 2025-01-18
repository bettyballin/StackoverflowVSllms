import java.lang.String;
public class DoublePartExtraction {
    public static void main(String[] args) {
        double number = 3.25; // Your input goes here

        int whole = (int) Math.floor(number);
        System.out.println("Whole: " + whole);         // Output - Whole: 3

        double fractional = number - Math.floor(number);
        System.out.println("Fractional: " + String.format("%.2f", fractional));   // Output - Fractional: .25
    }
}