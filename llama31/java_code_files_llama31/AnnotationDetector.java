/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class AnnotationDetector
implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) throws IllegalClassFormatException {
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}
