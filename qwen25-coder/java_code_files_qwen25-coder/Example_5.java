import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example_5 {
    private static final Logger logger = LoggerFactory.getLogger(Example_5.class);

    public void someMethod() {
        logger.info("Executing method: {}", () -> new Throwable().getStackTrace()[0].getMethodName());
    }

    public static void main(String[] args) {
    }
}