import java.lang.String;
public class BinaryIndexedTree {
    private int[] bit;

    public BinaryIndexedTree(int n) {
        bit = new int[n + 1];
    }

    public void insert(int i, int value) {
        while (i < bit.length) {
            bit[i] += value;
            i += (i & -i); // add least significant bit to move to parent
        }
    }

    public void remove(int i, int value) {
        while (i < bit.length) {
            bit[i] -= value;
            i += (i & -i); // add least significant bit to move to parent
        }
    }

    public int getCumulativeSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i); // subtract least significant bit to move to child
        }
        return sum;
    }

	public static void main(String[] args) {
	}
}