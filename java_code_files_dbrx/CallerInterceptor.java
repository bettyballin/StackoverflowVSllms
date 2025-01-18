public class CallerInterceptor implements MethodInterceptor {
    private static final ThreadLocal<String> CALLER = new ThreadLocal<>();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Class<?> callerClass = findCallerClass();
        System.out.println("Caller: " + callerClass);  // Print the calling class information here or do whatever you want with it

        try {
            return methodInvocation.proceed();
        } finally {
            CALLER.remove();
        }
    }

    private Class<?> findCallerClass() throws Exception {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        // Check the second element for the caller
        if (stack.length > 1) {
            return Class.forName(stack[1].getClassName());
        } else {
            throw new Exception("Unable to find a calling class");
        }
    }

    public static void main(String[] args) throws Throwable {
        MethodInvocation methodInvocation = new MethodInvocation() {
            @Override
            public Object proceed() throws Throwable {
                return null; // Do nothing
            }
        };

        CallerInterceptor ci = new CallerInterceptor();
        ci.invoke(methodInvocation);
    }
}

interface MethodInterceptor {
    Object invoke(MethodInvocation methodInvocation) throws Throwable;
}

interface MethodInvocation {
    Object proceed() throws Throwable;
}