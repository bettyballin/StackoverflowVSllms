import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunNotifier;
import org.junit.Test;

public class IsolatedRunner extends BlockJUnit4ClassRunner {
    public IsolatedRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        for (FrameworkMethod method : getTestClass().getAnnotatedMethods(Test.class)) {
            runLeaf(method, notifier);
        }
    }

    public static void main(String[] args) {
    }
}