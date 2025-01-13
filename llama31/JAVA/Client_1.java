import com.example.AnalyticsPortType;
import com.example.AnalyticsService;

public class Client_1_1 {
    public static void main(String[] args) {
        AnalyticsService service = new AnalyticsService();
        AnalyticsPortType port = service.getAnalyticsPort();
        // Use the port to access the web service
    }
}