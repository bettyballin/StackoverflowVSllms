import java.lang.String;
import java.util.*;
import java.util.concurrent.locks.*;

public class SynchronousQueue {

  private Queue<String> queue = new LinkedList<>();
  ReentrantLock lock = new ReentrantLock();

  public void put(String item) {
    try {
      lock.lock();
      this.queue.add(item);
    } finally {
      lock.unlock();
    }
  }

  public String get() {
    try {
      lock.lock();
      return this.queue.poll();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
  }
}