import java.lang.String;

public class Test_13_13 {
    public void foo(String arg) { 
        System.out.println("foo(String)");
    }

    public void foo(Object arg) { 
        System.out.println("foo(Object)");
    }

    public static void main(String[] args) {
        Test_13 test = new Test_13();
        Object testVal = null;
        test.foo(testVal); // dispatched to foo(Object)
        // test.foo(null); // compilation problem -> "The method foo(String) is ambiguous"
    }
}