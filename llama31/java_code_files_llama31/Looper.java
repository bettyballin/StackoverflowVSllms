/*
 * Decompiled with CFR 0.152.
 */
public class Looper {
    public static void main(String[] stringArray) {
        new Looper().loop();
    }

    public void loop() {
        for (int i = 0; i < 10 && !this.isEnough(i); ++i) {
        }
    }

    public boolean isEnough(int n) {
        return n > 5;
    }
}
