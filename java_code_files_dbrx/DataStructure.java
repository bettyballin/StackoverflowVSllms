import java.lang.String;
import java.util.concurrent.locks.*;

public class DataStructure {
   private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

   public void writeMethod() {
      try {
         lock.writeLock().lock();  //acquire exclusive (writer) access here
       	//...code to manipulate your data structure
      } finally {
            lock.writeLock().unlock();   //release writer's lock when done
      }
   }

   public void readMethod() {
       try {
           lock.readLock().lock();       //acquire shared (reader) access
   	        //...code that only reads data structure values, doesn't alter it
       } finally {
            lock.readLock().unlock();   //release reader's lock when done
      }
   }

	public static void main(String[] args) {
	}
}