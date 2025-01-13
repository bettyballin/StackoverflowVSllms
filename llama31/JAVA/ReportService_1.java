import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Define a simple Report class for demonstration purposes
class Report {
    private String id;
    private String content;

    public Report(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

// Define a simple Cache interface
interface Cache<K, V> {
    V get(K key);
    void put(K key, V value);
}

// Use caching to store frequently accessed data
public class ReportService_1 {
    private final Cache<String, Report> reportCache;

    public ReportService(Cache<String, Report> reportCache) {
        this.reportCache = reportCache;
    }

    public Report getReport(String reportId) {
        Report report = reportCache.get(reportId);
        if (report == null) {
            report = loadReportFromDatabase(reportId);
            reportCache.put(reportId, report);
        }
        return report;
    }

    private Report loadReportFromDatabase(String reportId) {
        // Load report from database
        // For demonstration purposes, return a dummy report
        return new Report(reportId, "This is a dummy report");
    }

    public static void main(String[] args) {
        // Create a cache implementation using ConcurrentHashMap
        Cache<String, Report> cache = new Cache<String, Report>() {
            private ConcurrentMap<String, Report> map = new ConcurrentHashMap<>();

            @Override
            public Report get(String key) {
                return map.get(key);
            }

            @Override
            public void put(String key, Report value) {
                map.put(key, value);
            }
        };

        // Create a ReportService instance with the cache
        ReportService reportService = new ReportService(cache);

        // Test the getReport method
        Report report = reportService.getReport("report-1");
        System.out.println(report.getContent());
    }
}