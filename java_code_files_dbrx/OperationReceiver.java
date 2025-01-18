import java.io.*;

public class OperationReceiver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] opBytesFromA = receiveFromStreamA(); // Receive bytes from A over network or other means
        ByteArrayInputStream bis = new ByteArrayInputStream(opBytesFromA);
        ObjectInput in = new ObjectInputStream(bis);
        Operation objA = (Operation) in.readObject();
        // Here we can call operations on the returned object as it is a valid Operation instance, no matter what implementation lies behind.
        objA.perform();
    }

    public static byte[] receiveFromStreamA() throws IOException {
        // Simulate receiving bytes by serializing an Operation object
        Operation op = new Operation();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(op);
        out.flush();
        return bos.toByteArray();
    }
}

class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    public void perform() {
        System.out.println("Operation performed");
    }
}