/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class AsyncProfilerRunner {
    public static void main(String[] stringArray) throws IOException {
        String[] stringArray2 = new String[]{"java", "-cp", "/path/to/async-profiler.jar", "com.github.asyncprofiler.AsyncProfiler", "-d", "30", "-f", "profile.html", "-t", "<pid>", "-e", "CPU"};
        Runtime.getRuntime().exec(stringArray2);
    }
}
