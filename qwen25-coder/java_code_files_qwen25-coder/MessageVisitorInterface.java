import java.lang.String;

public class MessageVisitorInterface {
    public interface IMessageVisitor {
        void visit(ConcreteMessageA message);
        void visit(ConcreteMessageB message);
    }

    public static class ConcreteMessageA {
    }

    public static class ConcreteMessageB {
    }

    public static void main(String[] args) {
    }
}