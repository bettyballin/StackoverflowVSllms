import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication {

    public ManagerApplication(MeterRegistry meterRegistry) {     
        new ProcessorMetrics().bindTo(meterRegistry); // Example of binding system metrics
    }

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}