public class GetMethodName {
    public void someMethod() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        System.out.println("Executing method: " + methodName);
    }

    public static void main(String[] args) {
    }
}