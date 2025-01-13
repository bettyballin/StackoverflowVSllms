/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

class MethodAccessTransformer
implements ClassFileTransformer {
    MethodAccessTransformer() {
    }

    @Override
    public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) throws IllegalClassFormatException {
        if (string.startsWith("groovy/") || string.startsWith("freemarker/")) {
            return byArray;
        }
        return null;
    }

    public static void main(String[] stringArray) {
    }
}
