import java.lang.String;
import java.lang.Integer;
public class MyApplication_6 {
    public static void main(String[] args) {
        // Simulate some heavy processing or data operations
        processData();
    }

    public static void processData() {
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
            sum += i;
            System.out.println(sum); // Just to simulate output operation
        }
    }
}