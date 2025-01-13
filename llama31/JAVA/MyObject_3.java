import java.lang.reflect.Method;

class MyObject {
    public void myMethod(String arg) {
        System.out.println(arg);
    }
}

class PrivilegedExecuter {
    private Object obj;

    public PrivilegedExecuter(Object obj) {
        this.obj = obj;
    }

    public void executeMethod(String methodName, String arg) {
        try {
            Method method = obj.getClass().getMethod(methodName, String.class);
            method.invoke(obj, arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MyObject_3_3 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        PrivilegedExecuter priv = new PrivilegedExecuter(myObject);
        priv.executeMethod("myMethod", "Hello, World!");
    }
}