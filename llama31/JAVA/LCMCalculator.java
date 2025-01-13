import java.lang.String;
public class LCMCalculator {
    public static int calculateLCM(int... numbers) {
        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = (lcm * numbers[i]) / gcd(lcm, numbers[i]);
        }
        return lcm;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5};
        int lcm = calculateLCM(numbers);
        System.out.println("LCM: " + lcm);
    }
}