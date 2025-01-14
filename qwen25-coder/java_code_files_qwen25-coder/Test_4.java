import java.lang.String;
class Counter {
    int value;
}

public class Test_4 {
    static Counter foo = new Counter();

    public static void main(String[] args) {
        synchronized(foo) {
            foo.value++;
            foo.notifyAll();
        }
        System.err.println("Success");
    }
}