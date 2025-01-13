import java.lang.String;
public class PartitionGenerator {
    public static void generatePartitions(int n) {
        generatePartitions(n, n, "");
    }

    private static void generatePartitions(int n, int max, String current) {
        if (n == 0) {
            System.out.println(current);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            generatePartitions(n - i, i, current + (current.isEmpty() ? "" : "+") + i);
        }
    }

    public static void main(String[] args) {
        generatePartitions(5);
    }
}