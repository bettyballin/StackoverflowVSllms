import java.lang.String;
public class RoundingHelper {
    public int roundToNearestHundred(int num) {
        return (int)(Math.round((double)num / 100.0)) * 100;
    }
    public static void main(String[] args) {
    }
}