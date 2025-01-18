import java.lang.String;
public interface IMessage {
   void accept(IMessageVisitor visitor);  // This function will be used for double-dispatching the behavior. Each concrete message must implement it accordingly.
}

// ConcreteMessage1 implements accept() and passes itself to the visitor
public class ConcreteMessage1 implements IMessage {
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this); // Passing current object of type ConcreteMessage1, so it could be treated accordingly by each concrete visitor's implementation.
   }
}

// Implementations for other ConcreteMessages2, ..., N also here
public class ConcreteMessageN implements IMessage {
    public void accept(IMessageVisitor visitor) {
        visitor.visit(this); // Passing current object of type ConcreteMessageN.
   }
}

public interface IMessageVisitor {  // The Visitor Interface which will include all visit() methods that handle specific operations per Concrete Message Types
    void visit(ConcreteMessage1 message);
    void visit(ConcreteMessageN message);

    public static void main(String[] args) {
    }
}