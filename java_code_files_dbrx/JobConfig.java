import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class JobConfig {

    @Autowired
    public JobBuilderFactory jobBuilders;

    @Autowired
    public StepBuilderFactory stepBuilders;

    // Define your batch jobs and steps here.

    public static void main(String[] args) {
    }
}

// Dummy class declarations to allow compilation
class JobBuilderFactory {}
class StepBuilderFactory {}