/*
 * Decompiled with CFR 0.152.
 */
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

private static class MemoryMonitorAgent.MemoryMonitorTransformer
implements ClassFileTransformer {
    private MemoryMonitorAgent.MemoryMonitorTransformer() {
    }

    @Override
    public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) {
        if (MemoryMonitorAgent.isUntrustedClass(string)) {
            MemoryMonitorAgent.MemoryMonitor memoryMonitor = new MemoryMonitorAgent.MemoryMonitor(0x40000000L);
            Thread.currentThread().setUncaughtExceptionHandler(memoryMonitor);
        }
        return byArray;
    }
}
