import java.io.IOException;

// Using REST client (hypothetical)
public class VehicleServiceClient {
    private HttpClient httpClient;

    public void startRemoteCar(String carId) throws IOException {
        String url = "http://api.vehicles.com/cars/" + carId + "/start";
        httpClient.sendHttpRequest(url, HttpMethod.PUT);
    }

    public static void main(String[] args) {
        // You can add code here to test the classes if needed
    }
}

// Local class following Law of Demeter
class Car {
    private Engine engine;

    public void start() {
        engine.startEngine(); // Direct interaction only
    }
}

// Simple Engine class stub
class Engine {
    public void startEngine() {
        // Stub method
    }
}

// Simple HttpClient class stub
class HttpClient {
    public void sendHttpRequest(String url, HttpMethod method) {
        // Stub method
    }
}

// Simple HttpMethod enum stub
enum HttpMethod {
    GET, POST, PUT, DELETE;
}