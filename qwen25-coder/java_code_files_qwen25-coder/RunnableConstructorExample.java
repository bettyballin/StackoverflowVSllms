import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RunnableConstructorExample {

    static Class<? extends Runnable> runClass = MyRunnable.class;

    static {
        try {
            // Using Class.newInstance(), less flexible and throws more exceptions
            Runnable runnable = runClass.newInstance();
            runnable.run();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Using Constructor.newInstance(), more flexible and clearer error handling
        try {
            Constructor<? extends Runnable> constructor = runClass.getConstructor();
            Runnable doRun = constructor.newInstance();
            doRun.run();
        } catch (NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Main method can remain empty or include additional code
    }

    public static class MyRunnable implements Runnable {
        public MyRunnable() {
            System.out.println("MyRunnable constructor called");
        }

        @Override
        public void run() {
            System.out.println("MyRunnable run method called");
        }
    }
}