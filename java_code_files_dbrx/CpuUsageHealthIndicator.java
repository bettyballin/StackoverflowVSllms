import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@Component
public class CpuUsageHealthIndicator implements HealthIndicator {
    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public Health health() {
        double cpuUsage = getCpuUsage(); // Implement this method to retrieve the CPU usage metric
        if (cpuUsage > 80) return Health.down().withDetail("CPU Usage", cpuUsage).build();
        else return Health.up().withDetail("CPU Usage", cpuUsage).build();
    }

    private double getCpuUsage() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        // Check if the platform MXBean is an instance of com.sun.management.OperatingSystemMXBean
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) osBean;
            return os.getSystemCpuLoad() * 100.0;
        } else {
            // Cannot get CPU load
            return 0.0;
        }
    }

    public static void main(String[] args) {
        CpuUsageHealthIndicator indicator = new CpuUsageHealthIndicator();
        System.out.println(indicator.health());
    }
}

// Define HealthIndicator interface
interface HealthIndicator {
    Health health();
}

// Define MeterRegistry class
class MeterRegistry {
    // Empty class for compilation purposes
}

// Define Health class with builder pattern
class Health {
    private String status;
    private String detailKey;
    private Object detailValue;

    public static HealthBuilder down() {
        return new HealthBuilder("DOWN");
    }

    public static HealthBuilder up() {
        return new HealthBuilder("UP");
    }

    @Override
    public String toString() {
        return "Status: " + status + ", Details: {" + detailKey + "=" + detailValue + "}";
    }

    // Inner class for building Health instances
    public static class HealthBuilder {
        private String status;
        private String detailKey;
        private Object detailValue;

        public HealthBuilder(String status) {
            this.status = status;
        }

        public HealthBuilder withDetail(String key, Object value) {
            this.detailKey = key;
            this.detailValue = value;
            return this;
        }

        public Health build() {
            Health health = new Health();
            health.status = this.status;
            health.detailKey = this.detailKey;
            health.detailValue = this.detailValue;
            return health;
        }
    }
}

// Define @Component and @Autowired annotations
@interface Component {}
@interface Autowired {}