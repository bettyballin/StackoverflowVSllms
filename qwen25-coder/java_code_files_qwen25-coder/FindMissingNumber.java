import java.lang.String;
import java.util.Scanner;

public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long n = (1L << 32) - 1; // 2^32 - 1
        long expectedSum = (n * (n + 1)) / 2; // Calculate the expected sum using arithmetic series formula
        
        long actualSum = 0;
        while (scanner.hasNextInt()) {
            actualSum += scanner.nextInt();
        }
        
        long missingNumber = expectedSum - actualSum;
        System.out.println("The missing number is: " + missingNumber);
    }
}