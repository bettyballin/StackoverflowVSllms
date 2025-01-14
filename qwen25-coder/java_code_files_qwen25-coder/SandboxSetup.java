import java.lang.String;
// Example of setting up a sandbox environment
import org.junit.jupiter.api.BeforeAll;

public class SandboxSetup {
    @BeforeAll
    static void init() {
        System.setProperty("environment", "sandbox");
    }

    public static void main(String[] args) {
    }
}