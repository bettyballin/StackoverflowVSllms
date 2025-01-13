import java.lang.Integer;
import java.lang.String;
public class IntegerArrayBenchmark {
    public static void main(String[] args) {
        int[] intArray = new int[1000000];
        Integer[] integerArray = new Integer[1000000];

        // Initialize arrays
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
            integerArray[i] = i;
        }

        // Benchmark
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        long endTime = System.nanoTime();
        System.out.println("int array: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sum = 0;
        for (int i = 0; i < integerArray.length; i++) {
            sum += integerArray[i];
        }
        endTime = System.nanoTime();
        System.out.println("Integer array: " + (endTime - startTime) + " ns");
    }
}