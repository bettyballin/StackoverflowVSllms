/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class CoverageAgent
implements ClassFileTransformer {
    private Instrumentation instrumentation;

    public CoverageAgent(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    @Override
    public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) throws IllegalClassFormatException {
        return byArray;
    }

    public static void premain(String string, Instrumentation instrumentation) {
        instrumentation.addTransformer(new CoverageAgent(instrumentation));
    }

    public static void main(String[] stringArray) {
    }
}
