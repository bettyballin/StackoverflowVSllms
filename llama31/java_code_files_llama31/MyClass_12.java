/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyClass_12 {
    private AtomicInteger val = new AtomicInteger(0);
    private AtomicIntegerArray ary = new AtomicIntegerArray(10);

    public void someMethod() {
        this.val.incrementAndGet();
        this.ary.addAndGet(0, 10);
        this.ary.incrementAndGet(1);
    }

    public static void main(String[] stringArray) {
    }
}
