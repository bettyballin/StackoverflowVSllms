/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Main_209 {
    public static void main(String[] stringArray) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int n = 100;
        int n2 = atomicInteger.getAndAdd(n);
        int n3 = n2 + n;
        System.out.println("Start Index: " + n2);
        System.out.println("End Index: " + n3);
    }
}
