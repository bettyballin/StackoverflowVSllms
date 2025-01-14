import java.lang.String;
public class Example_3 {
    public static void main(String[] args) {
        int number = 10; // Compile-time action: Memory is allocated for 'number'
        
        if (number > 5) { // Run-time action: Condition evaluated at execution time
            System.out.println("Number is greater than 5");
        }
    }
}