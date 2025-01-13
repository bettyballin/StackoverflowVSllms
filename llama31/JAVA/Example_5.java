import java.lang.String;
public class Example_5 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // VM can observe that the loop is executed 10 times
        // and optimize the loop unrolling accordingly
    }
}