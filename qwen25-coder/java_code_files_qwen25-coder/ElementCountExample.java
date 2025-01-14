import java.lang.String;
public class ElementCountExample {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6, 7, 8};
        int[] counts = new int[9]; // Assuming values range from 0 to 8

        for (int number : numbers) {
            counts[number]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + " : " + counts[i]);
        }
    }
}