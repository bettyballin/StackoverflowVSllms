import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyClass {
    public static List<Integer> getMultipliers(int x, int y) {
        List<Integer> multipliers = new ArrayList<>();
        
        while (x > y) {
            int remainder = x % y;
            multipliers.add(remainder);
            x = x / y;
        }
        
        // Add the last remaining value of x
        multipliers.add(x);
        
        // Reverse the list to maintain order from highest power to lowest
        Collections.reverse(multipliers);
        
        return multipliers;
    }
    
    public static void main(String[] args) {
        // Example usage
        int x = 100;
        int y = 3;
        List<Integer> result = getMultipliers(x, y);
        System.out.println("Multipliers: " + result);
    }
}