public class MyClass {
    // Java example: behavior guaranteed by JVM specification but not necessarily identical binary execution
    public int add(int a, int b) {
        return a + b; // Behavior across platforms is consistent, but may execute differently at the machine level
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        int result = obj.add(2, 3);
        System.out.println("Result: " + result);
    }
}