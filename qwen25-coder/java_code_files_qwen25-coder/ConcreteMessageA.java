import java.lang.String;

interface IMessage {
    void accept(IMessageVisitor visitor);
}

interface IMessageVisitor {
    void visit(ConcreteMessageA messageA);
    void visit(ConcreteMessageB messageB);
}

class ConcreteMessageA implements IMessage {
    @Override
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this);
    }
}

public class ConcreteMessageB implements IMessage {
    @Override
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this);
    }

    public static void main(String[] args) {
        // You can add code here to test the classes if needed
    }
}