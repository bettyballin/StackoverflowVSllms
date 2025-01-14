import java.lang.String;
public class LoopWithTempVariable {
    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            int i_tmp2 = someComputation(array[i]);
            // Use i_tmp2 for further calculations or checks within the loop
        }
    }

    static int[] array; // Declaration of array

    static int someComputation(int value) {
        // Placeholder method
        return value;
    }
}