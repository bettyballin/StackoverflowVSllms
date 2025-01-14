public class MyServiceInterface {
    // Example of a simple GWT-RPC Service Interface
    public interface MyService extends RemoteService {
        void saveData(ClientObject data);
    }
    public static void main(String[] args) {
    }
}

interface RemoteService {
}

class ClientObject {
}