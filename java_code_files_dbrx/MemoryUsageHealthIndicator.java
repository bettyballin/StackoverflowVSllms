import java.lang.String;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@Component
public class MemoryUsageHealthIndicator implements HealthIndicator {
    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public Health health() {
        double memoryUsage = getMemoryUsage(); // Implemented getMemoryUsage method
        if (memoryUsage > 80)
            return Health.down().withDetail("Memory Usage", memoryUsage).build();
        else
            return Health.up().withDetail("Memory Usage", memoryUsage).build();
    }

    private double getMemoryUsage() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long maxMemory = heapMemoryUsage.getMax();
        long usedMemory = heapMemoryUsage.getUsed();

        double usage = ((double) usedMemory / (double) maxMemory) * 100.0;
        return usage;
    }

    public static void main(String[] args) {
    }
}