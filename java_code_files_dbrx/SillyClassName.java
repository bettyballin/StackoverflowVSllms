import java.lang.String;
public class SillyClassName {
    Object moo = new Object();

    public void method1() {
        synchronized (moo) {
            System.out.println("method1 - got lock on moo");
            method2();
        }
    }

    public void method2() {
        synchronized (moo) {
            System.out.println("method2 - also got lock on moo");
            //doStuff();
        }
    }

	public static void main(String[] args) {
	}
}