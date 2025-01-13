import java.lang.Integer;
import java.lang.String;
public class test_1 {
    static Integer foo = new Integer(1);
    public static void main(String[] args) {
        synchronized(foo) {
            foo = foo + 1; // doesn't reassign foo
            foo.notifyAll(); // still throws IllegalMonitorStateException
        }
        System.err.println("Success");
    }
}