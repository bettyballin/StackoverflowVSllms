import java.io.IOException;

public class AsyncProfilerRunner {
    public static void main(String[] args) throws IOException {
        String[] command = {
            "java",
            "-cp",
            "/path/to/async-profiler.jar",
            "com.github.asyncprofiler.AsyncProfiler",
            "-d",
            "30",
            "-f",
            "profile.html",
            "-t",
            "<pid>",
            "-e",
            "CPU"
        };

        Runtime.getRuntime().exec(command);
    }
}