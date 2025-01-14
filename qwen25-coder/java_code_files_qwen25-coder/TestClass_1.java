public class TestClass {

    void doSomething(String param) {
        System.out.println("String");
    }

    void doSomething(Integer param) {
        System.out.println("Integer");
    }

    public static void main(String[] args) {

        TestClass test = new TestClass();

        // Calling with null without explicit cast can lead to ambiguity or warning
        // test.doSomething(null); // This might cause a compile-time error or IDE warning

        // Explicitly casting null eliminates any confusion about which method to call
        test.doSomething((String) null);
        test.doSomething((Integer) null);
    }
}