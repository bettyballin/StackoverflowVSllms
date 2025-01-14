import java.lang.String;
public class Example_10 {
    public void foo(String arg) {
        System.out.println("foo(String)");
    }

    public void foo(Object arg) {
        System.out.println("foo(Object)");
    }

    // This would also cause ambiguity if present
    // public void foo(Runnable arg) {
    //     System.out.println("foo(Runnable)");
    // }

    public static void main(String[] args) {
        Object testVal = null;
        Example_10 example = new Example_10();
        example.foo(testVal);    // Calls foo(Object)

        // foo(null);       // Compilation error: ambiguous method call
    }
}