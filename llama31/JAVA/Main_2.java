import java.util.ArrayList;
import java.util.List;

public class Main_2_2 {
    public static void main(String[] args) {

        int number = 100;
        int sum = 0;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                numbers.add(i);
            }
        }
        System.out.println("The sum is: " + sum);
        System.out.println("The numbers are: " + numbers);
    }
}