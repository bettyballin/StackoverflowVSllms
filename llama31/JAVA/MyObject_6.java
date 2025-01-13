// Define the interface in its own file: MyObjectMBean.java
public interface MyObjectMBean {
    public void dumpState();
}

// Define the class in its own file: MyObject_6.java
public class MyObject_6_6 implements MyObjectMBean {
    @Override
    public void dumpState() {
        // implementation
    }

    public static void main(String[] args) {
        // You may want to create an instance and call dumpState here
        MyObject_6 obj = new MyObject_6();
        obj.dumpState();
    }
}