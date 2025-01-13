public interface BusinessServiceAPI {
    void sendData(String data);
    String receiveData();
}

public class Main {
    public static void main(String[] args) {
        // You can't instantiate an interface, so we can't test the methods here.
        // You would need to create a class that implements BusinessServiceAPI.
    }
}