import java.lang.String;
public class SimpleBenchmark {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        int count = 100000;
        for (int i = 0; i < count; i++) {
            Math.sqrt(i);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}