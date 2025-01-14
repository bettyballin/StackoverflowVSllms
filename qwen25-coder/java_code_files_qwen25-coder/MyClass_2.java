import java.lang.String;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyClass_2 {   
    class MyClass {
      AtomicIntegerArray array = new AtomicIntegerArray(10); // Example size
    
      public void someMethod() {
        for (int i = 0; i < array.length(); i++) {
          int value = array.get(i);
          while (!array.compareAndSet(i, value, value + 1)) { // Atomically add 1
            value = array.get(i); // Retry if CAS fails
          }
        }
      }
    }
    public static void main(String[] args) {
    }
}