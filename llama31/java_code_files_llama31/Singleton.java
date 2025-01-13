/*
 * Decompiled with CFR 0.152.
 */
public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] stringArray) {
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();

        private Holder() {
        }
    }
}
