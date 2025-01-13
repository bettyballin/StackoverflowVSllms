import java.lang.String;

public class ServiceInvoker {
    // Assuming YourService is an interface and client is an instance of a class implementing it
    public static void main(String[] args) {
        // For demonstration purposes, let's assume client is created like this
        YourService client = new YourServiceImplementation();

        ServiceInvoker invoker = new ServiceInvoker(client);
        invoker.invokeService();
    }

    private YourService service;

    public ServiceInvoker(YourService client) {
        this.service = client;
    }

    public void invokeService() {
        service.yourMethod("arg1", "arg2");
    }
}

// Define the interface for YourService
interface YourService {
    void yourMethod(String arg1, String arg2);
}

// A simple implementation of YourService for demonstration purposes
class YourServiceImplementation implements YourService {
    @Override
    public void yourMethod(String arg1, String arg2) {
        System.out.println("Service invoked with arguments: " + arg1 + ", " + arg2);
    }
}