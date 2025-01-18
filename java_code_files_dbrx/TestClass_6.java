import java.lang.String;
public class TestClass_6 {
  static class TestClass {
    public void foo(String arg) { // More-specific
      System.out.println("foo(String)");
    }

    public void foo(Object arg) { // Generic
      System.out.println("foo(Object)");
    }
  }

  public static void main(String[] args) {
    TestClass test = new TestClass();
    Object testVal = null;
    test.foo(testVal);       // dispatching to foo(Object) because the runtime type of `testVal` is Object
    // test.foo((String)null); // This will also work and print: "foo(String)"
  }
}