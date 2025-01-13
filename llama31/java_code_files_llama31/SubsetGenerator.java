/*
 * Decompiled with CFR 0.152.
 */
public class SubsetGenerator {
    public static void generateSubsets(String string) {
        int n = string.length();
        for (int i = 0; i < 1 << n; ++i) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if ((i & 1 << j) == 0) continue;
                stringBuilder.append(string.charAt(j));
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main(String[] stringArray) {
        SubsetGenerator.generateSubsets("abc");
    }
}
