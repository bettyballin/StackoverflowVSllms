import java.lang.String;
import java.lang.Integer;
public class TestClass_1 {
    public static void foo(Integer i) { System.out.println("Inside Integer variant"); }
    public static void foo(Float f)  { System.out.println("Inside Float variant");  }

    public static void main(String[] args) {
        // Without any explicit type information, this would generate a compile error due to ambiguity: which "foo" should be called?
        // foo((Object) null);

        foo( (Integer) null );       // Invokes variant for Integer
        foo( (Float)   null );       // Invokes variant for Float
    }
}