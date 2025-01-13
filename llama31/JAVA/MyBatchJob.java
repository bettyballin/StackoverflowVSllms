import java.lang.String;

// Define the BatchJob annotation
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface BatchJob {
}

// Define the BatchStep annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BatchStep {
}

@BatchJob
public class MyBatchJob {
    @BatchStep
    public void runStep() {
        // Code to run at 11:30 PM every day
    }

    public static void main(String[] args) {
    }
}