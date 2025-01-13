/*
 * Decompiled with CFR 0.152.
 */
public class GameLoop {
    public static void main(String[] stringArray) {
        joglplat joglplat2 = new joglplat();
        int n = 0;
        long l = System.nanoTime();
        while (true) {
            long l2 = System.nanoTime();
            try {
                long l3;
                joglplat2.controls();
                joglplat2.update();
                joglplat2.repaint();
                long l4 = System.nanoTime();
                long l5 = l4 - l2;
                ++n;
                if (System.nanoTime() - l >= 1000000000L) {
                    System.out.println("Framerate: " + n);
                    n = 0;
                    l = System.nanoTime();
                }
                if ((l3 = 16000000L - l5) > 0L) {
                    Thread.sleep(l3 / 1000000L, (int)(l3 % 1000000L));
                    continue;
                }
                Thread.yield();
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                continue;
            }
            break;
        }
    }
}
