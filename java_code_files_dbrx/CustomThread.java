import java.lang.String;

public class CustomThread {

    Thread thread = new Thread("My Custom Thread Name") {
        public void run() {
            //your code here...
        }
    };

    {
        thread.start();
    }

    public static void main(String[] args) {
        new CustomThread();
    }
}