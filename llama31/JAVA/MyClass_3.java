import java.lang.String;
public class MyClass_3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

class MyRunnable implements Runnable {
    public void run() {
        myMethod();
    }

    private void myMethod() {
        System.out.println("Hello from myMethod!");
    }
}