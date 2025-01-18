public class Test {
    private static final Object someObject = new Object();
    public void doSomething() {
         synchronized (someObject) {
             System.out.println(someObject.toString());
         }
    }
    public static void main(String[] args) {
        new Test().doSomething();
    }
}