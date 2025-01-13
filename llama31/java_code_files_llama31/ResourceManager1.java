/*
 * Decompiled with CFR 0.152.
 */
public class ResourceManager1 {
    private final Object mutex = new Object();
    Object resource = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getResource() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.resource == null) {
                this.resource = new Object();
            }
        }
        return this.resource;
    }

    public static void main(String[] stringArray) {
    }
}
