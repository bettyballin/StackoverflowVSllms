import java.lang.String;
import java.util.concurrent.atomic.AtomicInteger;

public class MyClass_35 {

    class MyClass {
        private final AtomicInteger[] vec;

        public MyClass(int size) {
            this.vec = new AtomicInteger[size];
            for (int i = 0; i < size; i++)
                vec[i] = new AtomicInteger();
        }

        int value; // assuming value is defined somewhere else

        public void someMethod() {
            for (int i = 0; i < vec.length; i++)
                vec[i].addAndGet(value); // assuming value is defined somewhere else
        }
    }

    public static void main(String[] args) {
    }
}