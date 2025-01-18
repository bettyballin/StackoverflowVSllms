import java.lang.String;
public class HeapTest {
    public static void main(String[] args) throws InterruptedException {
        long heapSize = Runtime.getRuntime().totalMemory(); // heapsize in bytes at the start
        while (true){
             System.out.println("used: " + (heapSize - Runtime.getRuntime().freeMemory())/1024/1024 +  "MB");
            Thread.sleep(500);
         }
     }
}