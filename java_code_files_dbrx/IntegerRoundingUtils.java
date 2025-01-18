import java.lang.String;
public class IntegerRoundingUtils {
    double diff;
    double[] fn;
    int n;
    double avgIncrement = diff / fn.length;
    int maxRoundUp = Math.min((int) (avgIncrement + 1), n);
    public static void main(String[] args) {
    }
}