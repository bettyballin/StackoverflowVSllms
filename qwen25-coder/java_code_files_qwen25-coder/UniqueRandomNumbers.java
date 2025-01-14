import java.lang.String;
import java.lang.Integer;
import java.security.SecureRandom;
import java.util.HashSet;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        int n = 10; // Range from 1 to n
        int count = n; // Number of unique random numbers needed

        SecureRandom secureRandom = new SecureRandom();
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < count) {
            int num = 1 + secureRandom.nextInt(n); // Generate number between 1 and n
            uniqueNumbers.add(num);
        }

        System.out.println("Unique random numbers: " + uniqueNumbers);
    }
}