public class NativeRMISecurityFactory implements RMIFactory {
    private static final long serialVersionUID = 1L;
    private String user;

    public NativeRMISecurityFactory(String user) {
        this.user = user;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        if (systemSupportsSecurityManager()) {
            thread.setContextClassLoader(new NativeRMISecurityClassLoader());
            System.setSecurityManager(new NativeRMISecurityManager(user));
        } else {
            throw new IllegalStateException("System does not support the use of a custom Security Manager.");
        }
        return thread;
    }

    private boolean systemSupportsSecurityManager() {
        SecurityManager sm = System.getSecurityManager();
        return sm == null || sm.getClass() == SecurityManager.class;
    }

    public static void main(String[] args) {
        // Sample usage
        NativeRMISecurityFactory factory = new NativeRMISecurityFactory("user");
        Runnable task = () -> System.out.println("Thread is running");
        Thread thread = factory.newThread(task);
        thread.start();
    }
}

interface RMIFactory {
    Thread newThread(Runnable runnable);
}

class NativeRMISecurityClassLoader extends ClassLoader {
    // Implement as per your requirements or leave empty.
}

class NativeRMISecurityManager extends SecurityManager {
    private String user;

    public NativeRMISecurityManager(String user) {
        this.user = user;
    }

    // Implement methods as per your requirements.
}