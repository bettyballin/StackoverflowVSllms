public class HistogramSimilarityCalculator {
    public float chi(float[] a, float[] b) {
        float sum = 0;
        for (int i = 0; i < a.length; ++i) { // assuming both are of same length
            sum += Math.min(a[i], b[i]);
        }
        return sum / histLength; // histLength is the total number of bins in our case, e.g., 256 (8-bit color depth).
    }

    private static final int histLength = 256; // total number of bins in our case

    public static void main(String[] args) {
    }
}