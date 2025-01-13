/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class MemoryMonitorAgent {
    private static final long MAX_MEMORY = 0x40000000L;

    public static void premain(String string, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MemoryMonitorTransformer());
    }

    private static boolean isUntrustedClass(String string) {
        return string.startsWith("untrusted.");
    }

    public static void main(String[] stringArray) {
    }

    private static class MemoryMonitorTransformer
    implements ClassFileTransformer {
        private MemoryMonitorTransformer() {
        }

        @Override
        public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) {
            if (MemoryMonitorAgent.isUntrustedClass(string)) {
                MemoryMonitor memoryMonitor = new MemoryMonitor(0x40000000L);
                Thread.currentThread().setUncaughtExceptionHandler(memoryMonitor);
            }
            return byArray;
        }
    }

    private static class MemoryMonitor
    implements Thread.UncaughtExceptionHandler {
        private final long maxMemory;

        public MemoryMonitor(long l) {
            this.maxMemory = l;
        }

        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            if (throwable instanceof OutOfMemoryError) {
                thread.interrupt();
            }
        }
    }
}
