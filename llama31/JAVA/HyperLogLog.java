import java.lang.Integer;
import java.lang.String;
public class HyperLogLog {
    private int p;
    private int m;
    private int[] M;

    public HyperLogLog(int p, int m) {
        this.p = p;
        this.m = m;
        this.M = new int[m];
    }

    public void add(long x) {
        int j = (int) (x % m);
        int w = (int) (x / m);
        M[j] = Math.max(M[j], Integer.numberOfTrailingZeros(w));
    }

    public double estimate() {
        double sum = 0;
        for (int i = 0; i < m; i++) {
            sum += Math.pow(2, -M[i]);
        }
        return Math.pow(2, p) * (1 / sum);
    }

	public static void main(String[] args) {
	}
}