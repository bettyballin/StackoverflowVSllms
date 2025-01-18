public class MyClass {
    private static final Object myLockObject = new Object();
    private static Object mySharedResource;

    public static void threadSafeMethod() {
        synchronized(myLockObject) {
            // modify mySharedResource ...
        }
    }
}