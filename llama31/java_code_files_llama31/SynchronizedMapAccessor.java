/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class SynchronizedMapAccessor {
    private HashMap<Integer, Object> map = new HashMap();

    public synchronized void myPut(int n) {
        this.map.put(n, null);
    }

    public static void main(String[] stringArray) {
        SynchronizedMapAccessor synchronizedMapAccessor = new SynchronizedMapAccessor();
        synchronizedMapAccessor.myPut(1);
    }
}
