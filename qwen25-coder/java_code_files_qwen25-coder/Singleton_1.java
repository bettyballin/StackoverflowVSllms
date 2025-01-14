import java.lang.String;
public class Singleton_1 {
    private static volatile Singleton_1 instance;

    private Singleton_1() {}

    public static Singleton_1 getInstance() {
        if (instance == null) {  // Check 1: No locking, fast path.
            synchronized (Singleton_1.class) { 
                if (instance == null) {  // Check 2: Locking and ensuring no second instantiation.
                    instance = new Singleton_1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
    }
}