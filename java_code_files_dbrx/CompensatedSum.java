import java.lang.String;
public class CompensatedSum {
    private double sum = 0; // accumulates the sum
    private double c = 0; // a running compensation for lost low-order bits

    public void add(double value) {
        double temp = value + c;
        if (Math.abs(value) > Math.abs(sum)) {
            c = (sum - temp) + value;
        } else {
            c = (c - (temp - sum));
        }
        sum = temp;
    }

    public double getSum() {
        return sum;
    }

	public static void main(String[] args) {
	}
}