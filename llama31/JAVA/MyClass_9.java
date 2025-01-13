import java.lang.String;
public class MyClass_9 {
    public void myMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName(); // 2 because we want the method that called this one
        System.out.println("Method name: " + methodName);
    }

	public static void main(String[] args) {
	}
}