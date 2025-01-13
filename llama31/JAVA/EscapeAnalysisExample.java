import java.lang.String;
public class EscapeAnalysisExample {
    public static void main(String[] args) {
        foo();
    }

    public static void foo() {
        Object o = new Object();
        // o is not escaping the method, so it can be allocated on the stack
    }
}