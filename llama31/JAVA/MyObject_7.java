import java.lang.String;

public interface MyObjectMBean {
    public String getStatus();
    public void alert(String message);
}

public class MyObject_7_7 implements MyObjectMBean {
    private String status = "OK";

    public String getStatus() {
        return status;
    }

    public void alert(String message) {
        System.out.println("Alert: " + message);
    }

    public static void main(String[] args) {
        MyObject_7 obj = new MyObject_7();
        obj.alert("Hello, World!");
        System.out.println("Status: " + obj.getStatus());
    }
}