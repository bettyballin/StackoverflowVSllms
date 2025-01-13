/*
 * Decompiled with CFR 0.152.
 */
public class ProgressBar_1 {
    public static void main(String[] stringArray) {
        for (int i = 0; i <= 100; ++i) {
            System.out.print("\u001b[2K\r");
            System.out.print("Progress: " + i + "%");
            try {
                Thread.sleep(50L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
