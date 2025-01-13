/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_9 {
    public void myMethod() {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        String string = stackTraceElementArray[2].getMethodName();
        System.out.println("Method name: " + string);
    }

    public static void main(String[] stringArray) {
    }
}
