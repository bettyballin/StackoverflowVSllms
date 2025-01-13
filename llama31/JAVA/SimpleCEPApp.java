import java.lang.String;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class SimpleCEPApp {
    public static void main(String[] args) {
        // Create an EPServiceProvider instance
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

        // Create an EPRuntime instance
        EPRuntime epRuntime = epService.getEPRuntime();

        // Create an EPStatement instance
        EPStatement epStatement = epService.getEPAdministrator().createEPL(
                "select * from MyEvent.win:length(10) where value > 5"
        );

        // Add a listener to the statement
        epStatement.addListener(new MyEventListener());

        // Send events to the engine
        epRuntime.sendEvent(new MyEvent(1, 10));
        epRuntime.sendEvent(new MyEvent(2, 15));
        epRuntime.sendEvent(new MyEvent(3, 7));
    }
}

class MyEvent {
    private int id;
    private int value;

    public MyEvent(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}

class MyEventListener implements UpdateListener {
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        System.out.println("Received event: " + newEvents[0].get("id") + ", value: " + newEvents[0].get("value"));
    }
}