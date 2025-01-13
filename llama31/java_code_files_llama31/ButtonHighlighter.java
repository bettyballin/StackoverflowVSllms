/*
 * Decompiled with CFR 0.152.
 */
public class ButtonHighlighter {
    public static void main(String[] stringArray) {
        ButtonHighlighter buttonHighlighter = new ButtonHighlighter();
        buttonHighlighter.run();
    }

    public void run() {
        int n;
        long l = System.currentTimeMillis();
        int n2 = 10;
        long[] lArray = new long[n2];
        for (n = 0; n < n2; ++n) {
            lArray[n] = 1000 * n;
        }
        for (n = 0; n < n2; ++n) {
            long l2 = System.currentTimeMillis() - l;
            if (l2 < lArray[n]) continue;
            this.highlightButton(n);
        }
    }

    public void highlightButton(int n) {
        System.out.println("Highlighting button " + n);
    }
}
