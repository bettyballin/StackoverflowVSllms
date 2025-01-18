import java.util.concurrent.ConcurrentHashMap;

public class GreetingController_1 {
    private final ConcurrentHashMap<Session, SlaveServerConnection> sessionToSlave = new ConcurrentHashMap<>();
    private SlaveAvailableService slaveAvailableService;

    @SubscribeMapping("/status")
    public StatusMessage getStatusFromSlave(Session payload)  throws Exception{
        // ... check if status is free or busy and return object accordingly...
        return slaveAvailableService.getStatus(sessionToSlave.get(payload).getId());
    }

    public static void main(String[] args) {
    }
}

@interface SubscribeMapping {
    String value();
}

class Session {
    // Define any necessary methods or fields
}

class SlaveServerConnection {
    public String getId() {
        return "dummyId";
    }
}

class StatusMessage {
    // Define any necessary methods or fields
}

class SlaveAvailableService {
    public StatusMessage getStatus(String id) {
        return new StatusMessage();
    }
}