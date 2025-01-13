import org.junit.Test;

public class MyTest_13_13 {

    @Test
    public void test1() {
        // test code
        System.out.println("Running test1");
    }

    @Test
    public void test2() {
        // test code
        System.out.println("Running test2");
    }

    public static void main(String[] args) {
        // Normally, JUnit tests are run with a test runner and not directly from the main method.
        // Here, we're just making sure the code can be compiled and executed.
        MyTest_13 myTest = new MyTest_13();
        myTest.test1();
        myTest.test2();
    }
}