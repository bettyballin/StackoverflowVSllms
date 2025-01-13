import java.lang.String;
public class Main_608 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 12, 3};
        sortList(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }

    public static void sortList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    // Swap list[i] and list[j] using one extra variable
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}