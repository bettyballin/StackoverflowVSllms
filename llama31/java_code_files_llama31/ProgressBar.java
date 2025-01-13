/*
 * Decompiled with CFR 0.152.
 */
public class ProgressBar {
    public static void main(String[] stringArray) {
        for (int i = 0; i <= 100; ++i) {
            System.out.print("\rProgress: " + i + "%");
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
