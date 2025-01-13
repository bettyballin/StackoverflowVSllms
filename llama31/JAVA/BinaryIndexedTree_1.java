public class BinaryIndexedTree_1 {
    private int[] tree;

    public BinaryIndexedTree(int size) {
        tree = new int[size + 1];
    }

    public void insert(int index, int value) {
        while (index < tree.length) {
            tree[index] += value;
            index += index & -index;
        }
    }

    public int getCumulativeSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    public void remove(int index, int value) {
        insert(index, -value);
    }

    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(10);

        bit.insert(1, 2);
        bit.insert(2, 3);
        bit.insert(3, 5);

        System.out.println(bit.getCumulativeSum(3)); // Output: 10

        bit.insert(1, 1); // Insert 1 at position 1

        System.out.println(bit.getCumulativeSum(4)); // Output: 11

        bit.remove(2, 2); // Remove 2 from position 2

        System.out.println(bit.getCumulativeSum(4)); // Output: 9
    }
}