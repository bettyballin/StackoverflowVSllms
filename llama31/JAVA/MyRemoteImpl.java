// Define the interface
public interface MyRemoteInterface {
    String sayHello();
}

// Implement the interface
public class MyRemoteImpl implements MyRemoteInterface {
    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        MyRemoteImpl impl = new MyRemoteImpl();
        System.out.println(impl.sayHello());
    }
}