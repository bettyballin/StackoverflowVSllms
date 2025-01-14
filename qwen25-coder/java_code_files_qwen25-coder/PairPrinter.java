import java.lang.String;

public class PairPrinter {
    public static void main(String[] args) {
        String[] arr = args;
        for(int i = 0; i < arr.length; i++) {
            for(int q = i + 1; q < arr.length; q++) {
                System.out.println(arr[i] + " " + arr[q]);
                System.out.println(arr[q] + " " + arr[i]);
            }
        }
    }
}