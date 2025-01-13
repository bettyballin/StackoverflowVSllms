import java.lang.Integer;
import java.lang.String;
public class test {
    static final Object lock = new Object();
    static Integer foo = new Integer(1);
    public static void main(String[] args) {
        synchronized(lock) {
            foo++;
            lock.notifyAll();
        }
        System.err.println("Success");
    }
}