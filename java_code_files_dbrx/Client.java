import java.lang.String;

interface IMessage {
    void accept(MyBehaviorVisitor visitor);
}

class MyBehaviorVisitor {
    // Implement visitor behavior here
}

public class Client{
   public void messageRecieved(IMessage message) {
      message.accept(new MyBehaviorVisitor());  // This will use double-dispatching and handle behavior appropriately based on concrete message type.
    }

    public static void main(String[] args) {
    }
}