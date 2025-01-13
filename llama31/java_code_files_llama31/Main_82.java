/*
 * Decompiled with CFR 0.152.
 */
public class Main_82 {
    public static void main(String[] stringArray) {
        byte[] byArray;
        for (byte by : byArray = new byte[]{18, 52, 86, 120}) {
            for (int i = 7; i >= 0; --i) {
                int n = by >> i & 1;
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
