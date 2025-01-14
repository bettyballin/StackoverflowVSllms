import java.lang.String;

public class IMessageVisitorAcceptor {
    public interface IMessage {
        void accept(IMessageVisitor visitor);
    }

    public interface IMessageVisitor {
        // Empty interface
    }

    public static void main(String[] args) {
    }
}