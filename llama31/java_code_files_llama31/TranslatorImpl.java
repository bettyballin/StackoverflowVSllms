/*
 * Decompiled with CFR 0.152.
 */
public class TranslatorImpl
implements Translator {
    private final Object lock = new Object();
    private volatile boolean isLoading = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void loadTranslations() {
        if (this.isLoading) {
            return;
        }
        Object object = this.lock;
        synchronized (object) {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            this.isLoading = false;
        }
    }

    public static void main(String[] stringArray) {
        TranslatorImpl translatorImpl = new TranslatorImpl();
        translatorImpl.loadTranslations();
    }
}
