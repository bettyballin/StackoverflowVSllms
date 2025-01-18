import java.lang.String;
public class MultiLockClass {
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  public void method() {
    synchronized(lock1) {
      // do stuff with resource1
    }

    synchronized(lock2) {
      // do stuff with resource2
    }
  }
  
  public static void main(String[] args) {
  }
}