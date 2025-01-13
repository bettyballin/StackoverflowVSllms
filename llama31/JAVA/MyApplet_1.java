import java.applet.Applet;

public class MyApplet_1_1 extends Applet {
    // ...

    @Override
    public void destroy() {
        // Close connections, release resources, etc.
        System.out.println("Applet is being destroyed...");
    }

    public static void main(String[] args) {
    }
}