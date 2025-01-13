import java.lang.String;
public class CpuLoadGenerator {
    public static void main(String[] args) {
        long durationMs = 500; // adjust this value to change the load duration
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < durationMs) {
            // perform some calculations to keep the CPU busy
            double result = 0;
            for (int i = 0; i < 100000; i++) {
                result += Math.sin(i) * Math.cos(i);
            }
        }
    }
}