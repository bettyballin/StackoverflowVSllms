import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.HTTPServer;

public class Example_8_8 {
    private static final Counter requests = Counter.build()
            .name("requests_total")
            .help("Total requests")
            .register();

    private static final Gauge memoryUsage = Gauge.build()
            .name("memory_usage_bytes")
            .help("Memory usage in bytes")
            .register();

    public static void main(String[] args) throws Exception {
        HTTPServer server = new HTTPServer(8000);
        while (true) {
            requests.inc();
            memoryUsage.set(12345);
            Thread.sleep(1000);
        }
    }
}