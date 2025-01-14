import java.lang.String;

public class Client_5 implements IMessageVisitor {

    private SomeClientData data; // Assuming you have some client-specific data

    public void messageReceived(IMessage message) {
        message.accept(this); // Dispatch based on message type
    }

    @Override
    public void visit(ConcreteMessageA message) {
        // do ConcreteMessageA operations using this.data if needed
    }

    @Override
    public void visit(ConcreteMessageB message) {
        // do ConcreteMessageB operations using this.data if needed
    }

    public static void main(String[] args) {
        // For testing, create Client_5 and send messages
        Client_5 client = new Client_5();
        client.data = new SomeClientData(); // initialize data

        IMessage messageA = new ConcreteMessageA();
        IMessage messageB = new ConcreteMessageB();

        client.messageReceived(messageA);
        client.messageReceived(messageB);
    }
}

interface IMessage {
    void accept(IMessageVisitor visitor);
}

interface IMessageVisitor {
    void visit(ConcreteMessageA message);
    void visit(ConcreteMessageB message);
}

class SomeClientData {
    // Some data fields
}

class ConcreteMessageA implements IMessage {
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteMessageB implements IMessage {
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this);
    }
}