import java.lang.String;
public class SillyClassName {
    private final Object moo = new Object();

    public void method1() {
        synchronized (moo) {
            System.out.println("Method 1 acquired lock");
            method2();
        }
    }

    public void method2() {
        synchronized (moo) {
            System.out.println("Method 2 acquired lock");
        }
    }

    public static void main(String[] args) {
        SillyClassName instance = new SillyClassName();
        instance.method1();
    }
}