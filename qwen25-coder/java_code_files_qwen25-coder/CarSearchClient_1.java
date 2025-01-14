import java.lang.String;
public class CarSearchClient_1 {
    CarService service = new CarService();
    CarPort port = service.getCarPort();
    carPackage.port.search searchResult = port.search("Toyota");

    public static void main(String[] args) {
    }
}