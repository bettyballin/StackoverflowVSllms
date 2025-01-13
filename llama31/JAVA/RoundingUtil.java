import java.lang.String;

public class RoundingUtil {
    public static int roundToNearest100(int num) {
        return (num + 50) / 100 * 100;
    }

    public static void main(String[] args) {
    }
}