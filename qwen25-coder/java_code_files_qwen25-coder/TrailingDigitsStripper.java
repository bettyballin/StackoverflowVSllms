public class TrailingDigitsStripper {
    int x = 12345;
    int n = 1; // Number of trailing digits to strip
    int result;

    {
        result = (int) Math.floor(x / Math.pow(10, n)); // Result: 1234
    }

    public static void main(String[] args) {
    }
}