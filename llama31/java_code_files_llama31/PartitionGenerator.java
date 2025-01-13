/*
 * Decompiled with CFR 0.152.
 */
public class PartitionGenerator {
    public static void generatePartitions(int n) {
        PartitionGenerator.generatePartitions(n, n, "");
    }

    private static void generatePartitions(int n, int n2, String string) {
        if (n == 0) {
            System.out.println(string);
            return;
        }
        for (int i = Math.min(n2, n); i >= 1; --i) {
            PartitionGenerator.generatePartitions(n - i, i, string + (string.isEmpty() ? "" : "+") + i);
        }
    }

    public static void main(String[] stringArray) {
        PartitionGenerator.generatePartitions(5);
    }
}
