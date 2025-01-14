import java.util.ArrayList;
import java.util.List;
import com.espertech.esper.client.*;

public class EspERExampleApp {
    public static void main(String[] args) {
        // Create default configuration and configure for single node environment
        Configuration config = new Configuration();
        config.addEventType(MyEvent.class);

        // Create runtime container
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        EPRuntime er = epService.getEPRuntime();  // Runtime allows inserting and processing events

        // Get statement for execution
        EPAdministrator ea = epService.getEPAdministrator();
        String eplStatement = "select avg(price) as avgPrice from MyEvent.win:time_batch(10 sec)";
        EPStatement eps = ea.createEPL(eplStatement);

        // Add a listener to handle output from the query
        eps.addListener((newData, oldData, stmt, rt) -> {
            if (newData != null) {
                double averagePrice = (double) newData[0].get("avgPrice");
                System.out.println("Average price: " + averagePrice);
            }
        });

        // Insert sample events into runtime...
        List<MyEvent> events = new ArrayList<>();
        events.add(new MyEvent(10));
        events.add(new MyEvent(20));
        events.forEach(er::sendEvent);

    }

    public static class MyEvent {
        private final double price;

        public MyEvent(double price) {
            this.price = price;
        }
        
        public double getPrice() { return price; }
    }
}