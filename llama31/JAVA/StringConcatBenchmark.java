import java.lang.String;
public class StringConcatBenchmark {
    public static void main(String[] args) {
        int numIterations = 100000;
        String url = "https://example.com";

        // Using + operator
        long startTime = System.nanoTime();
        for (int i = 0; i < numIterations; i++) {
            String html = "<a href='" + url + "'>click here</a>";
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken using + operator: " + (endTime - startTime) + " ns");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numIterations; i++) {
            sb.setLength(0); // reset the buffer
            sb.append("<a href='").append(url).append("'>click here</a>");
        }
        endTime = System.nanoTime();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + " ns");
    }
}