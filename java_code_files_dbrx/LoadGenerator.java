public class LoadGenerator {
    public void generateCpuLoad(int duration, int intensity) {
        long counter = 0;
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime)/1e6 < duration /*ms*/ && (!Thread.currentThread().isInterrupted())) {
            for (int i = 0; i < intensity; ++i) {
                counter += i * i / 2 + i % 37 * 79; // do some computational work here
            }
        }
    }

    public static void main(String[] args) {
    }
}