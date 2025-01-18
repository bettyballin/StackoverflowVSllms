public class RoundingCalculator {

    public void performCalculation(int[] fn, int diff, int maxRoundUp, int[] in, int n) {
        for (int i = 0; i < fn.length; i++) {
            int addend = (diff > 0 && i % maxRoundUp == 0) ? -1 : 0;
            int valueInt = (int) (fn[i] + addend);
            in[i] = Math.min(valueInt, n);
        }
    }

    public static void main(String[] args) {
        // You can add code here to test the performCalculation method if needed.
    }
}