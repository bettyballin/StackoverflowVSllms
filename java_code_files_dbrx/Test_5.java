import java.lang.String;
public class Test_5 {
    public static void main(String[] args){
        long start = System.nanoTime();
        new Test_5().test1();
        System.out.println("Unsynchronized method elapsed time (ns): " +  (System.nanoTime() - start));

        start = System.nanoTime();
        new Test_5().test2();
        System.out.println("Synchronized method elapsed time: " + (System.nanoTime() - start));
    }

    public synchronized void test1(){
        for(int i=0; i< 1_000_000; ++i) {}
    }

    // unsynchronized method
    public void test2(){
        for (int i = 0; i < 1_000_000; ++i){}
    }
}