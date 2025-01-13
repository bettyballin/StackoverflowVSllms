import java.lang.String;

public class MyObjectTest_1_1 {
    public static void main(String[] args) throws InterruptedException {
        testDefaultConstructor();
    }

    public static void testDefaultConstructor() throws InterruptedException {
        new MyObject();
        Thread.sleep(0); // Observable side effect
    }
}

class MyObject {
    public MyObject() {}
}