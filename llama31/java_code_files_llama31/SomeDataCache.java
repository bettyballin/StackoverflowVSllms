/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeDataCache {
    private final Lock lock = new ReentrantLock();

    private SomeData[] getSomeDataByEmail(WebServiceInterface webServiceInterface, String string) {
        String string2 = "Data-" + string;
        this.lock.lock();
        this.lock.unlock();
        return null;
    }

    public static void main(String[] stringArray) {
    }
}
