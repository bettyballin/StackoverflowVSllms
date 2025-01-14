import java.lang.String;
public class Main_61 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        long sum = 0;
        for (long i = 1; i < Long.MAX_VALUE / 2; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();
        System.out.println("Java Elapsed Time: " + (endTime - startTime) + " ns");
    }
}