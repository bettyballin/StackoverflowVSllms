import java.lang.String;
import java.applet.Applet;

// Standalone Java application
public class MyApplication_1_1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// Applet
class MyApplet extends Applet {
    @Override
    public void init() {
        System.out.println("Initializing applet...");
    }
}

// Thread
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}