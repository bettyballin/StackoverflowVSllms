import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class LazyTestRunner extends BlockJUnit4ClassRunner {
    public LazyTestRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Object createTest() throws Exception {
        // Create the test instance just before running it
        return getTestClass().getJavaClass().newInstance();
    }

    public static void main(String[] args) {
    }
}