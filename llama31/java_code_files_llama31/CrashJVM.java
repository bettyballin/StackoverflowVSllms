/*
 * Decompiled with CFR 0.152.
 */
import sun.misc.Unsafe;

public class CrashJVM {
    public static void main(String[] stringArray) {
        Unsafe unsafe = CrashJVM.getUnsafe();
        unsafe.putAddress(0L, 0L);
    }

    private static Unsafe getUnsafe() {
        try {
            return (Unsafe)Class.forName("sun.misc.Unsafe").newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
