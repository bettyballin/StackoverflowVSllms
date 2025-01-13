import java.lang.String;
public class Example_26 {
    public static void main(String[] args) {
        while (true) {
            myMethod();
        }
    }

    public static void myMethod() {
        // Do some work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}