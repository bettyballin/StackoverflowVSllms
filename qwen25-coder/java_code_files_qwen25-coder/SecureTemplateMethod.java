import java.lang.reflect.Method;
import java.util.List;
import java.util.Arrays;

// Mock interface to replace freemarker.template.TemplateMethodModelEx
interface TemplateMethodModelEx {
    Object exec(List arguments) throws TemplateModelException;
}

// Mock exception class to replace freemarker.template.TemplateModelException
class TemplateModelException extends Exception {
    public TemplateModelException(Throwable cause) {
        super(cause);
    }
}

public class SecureTemplateMethod implements TemplateMethodModelEx {
    private final Method delegate;

    // List of forbidden methods
    private static final List<String> FORBIDDEN_METHODS = Arrays.asList("forbiddenMethod");

    public SecureTemplateMethod(Method method) {
        this.delegate = method;
    }

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (FORBIDDEN_METHODS.contains(delegate.getName())) {
            throw new SecurityException("Access to method " + delegate.getName() + " is forbidden.");
        }
        try {
            return delegate.invoke(null, arguments.toArray());
        } catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }

    public static TemplateMethodModelEx wrap(Method method) {
        return new SecureTemplateMethod(method);
    }

    public static void main(String[] args) {
    }
}