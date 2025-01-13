/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.Instrumentation;

public class MethodAccessAgent {
    public static void premain(String string, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MethodAccessTransformer());
    }
}
