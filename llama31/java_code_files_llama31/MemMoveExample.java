/*
 * Decompiled with CFR 0.152.
 */
public class MemMoveExample {
    public static void main(String[] stringArray) {
        byte[] byArray = new byte[]{1, 2, 3, 4, 5};
        byte[] byArray2 = new byte[5];
        System.arraycopy(byArray, 0, byArray2, 0, 5);
        for (byte by : byArray2) {
            System.out.print(by + " ");
        }
    }
}
