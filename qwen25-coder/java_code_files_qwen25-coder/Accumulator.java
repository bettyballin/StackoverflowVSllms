import java.lang.String;
// Java example for accumulation using mutable state
public class Accumulator {
    private int sum;

    public Accumulator() {
        this.sum = 0;
    }

    public void add(int value) {
        this.sum += value;
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        Accumulator acc = new Accumulator();
        for (int i = 1; i <= 10; i++) {
            acc.add(i);
        }
        System.out.println("Total: " + acc.getSum()); // Output should be 55
    }
}