import java.lang.String;

public class CarSearchClient {
    public static void main(String[] args) {
        CarSearchClient client = new CarSearchClient();
        client.searchCar();
    }

    public void searchCar() {
        // Assuming port is an instance of a class that has a search method
        // You need to create an instance of that class or get it from somewhere
        // For demonstration purposes, let's assume it's a static method in carPackage.port
        String searchResult = carPackage.port.search("Toyota");
        System.out.println(searchResult);
    }
}