// Define interfaces and classes in separate files or wrap them in a single file with a main class
import java.lang.String;

// Define interfaces
interface IMessage {
    void process(ClientCallback callback);
}

interface ClientCallback {
    void doSomethingWithClientData();
}

// Define concrete classes
class ConcreteMessageA implements IMessage {
    @Override
    public void process(ClientCallback callback) {
        // do concreteMessageA operations
        callback.doSomethingWithClientData();
    }
}

class ConcreteMessageB implements IMessage {
    @Override
    public void process(ClientCallback callback) {
        // do concreteMessageB operations
        callback.doSomethingWithClientData();
    }
}

// Define a main class with a main method
public class Client implements ClientCallback {
    @Override
    public void doSomethingWithClientData() {
        // perform operations on client data
        System.out.println("Performing operations on client data");
    }

    public void messageReceived(IMessage message) {
        message.process(this);
    }

    public static void main(String[] args) {
        // Create instances and use them
        Client client = new Client();
        IMessage messageA = new ConcreteMessageA();
        IMessage messageB = new ConcreteMessageB();
        
        client.messageReceived(messageA);
        client.messageReceived(messageB);
    }
}