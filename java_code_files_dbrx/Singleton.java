public class Singleton {
    private volatile static Singleton instance;
    private static Object lock = new Object(); // or you could use Singleton itself as the lock

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (null == instance) // Double Checked Locking pattern: checks for null once more
                    instance = new Singleton();
            }
        }
        return instance;
    }

    private Singleton() {
        // Private constructor to prevent instantiation
    }
}