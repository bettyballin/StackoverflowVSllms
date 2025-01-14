import java.lang.String;
public class EndPoint {
    public void method() {
        Runnable r = new Runnable() { // Anonymous inner class
            @Override
            public void run() {
                System.out.println("Running");
            }
        };
        Thread t = new Thread(r);
        t.start();
        
        Runnable namedNested = new MyRunnable(); // Named nested class
    }

    class MyRunnable implements Runnable { // Named nested class
        @Override
        public void run() {
            System.out.println("Named nested running");
        }
    }

	public static void main(String[] args) {
	}
}