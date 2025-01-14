import java.lang.String;
public class SeparateParts {
    public static void main(String[] args) {
        double number = 3.25;
        
        // Get the whole part by casting the double to an int
        int whole = (int) number;
        
        // Calculate the fractional part by subtracting the whole part from the original number
        double fractional = number - whole;
        
        System.out.println("Whole: " + whole);
        System.out.println("Fractional: " + fractional);
    }
}