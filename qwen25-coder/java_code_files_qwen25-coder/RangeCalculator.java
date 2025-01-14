public class RangeCalculator {
    float someValue;
    int someOtherValue;
    float a = someValue;
    int b = someOtherValue;
    int c = Math.round((a + (b / 2.0f)) / b) - 1;

    {
        // Adjusting c to ensure it falls within the desired range
        c = (int) ((a + (b / 2.0f)) / b);
        if (a > 0) {
            c -= 1;
        }
    }

    public static void main(String[] args) {
    }
}