// Operation.java (interface definition)
public interface Operation {
    void execute();
}

// OperationImpl.java (implementation class, not available in app B's classpath)
class OperationImpl implements Operation {
    @Override
    public void execute() {
        System.out.println("Executing operation");
    }
}

// OperationProxy.java (serialization proxy class)
import java.io.Serializable;

class OperationProxy implements Operation, Serializable {
    private Operation delegate;

    public OperationProxy(Operation delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute() {
        delegate.execute();
    }
}

// App A (sender)
public class AppA {
    public static void main(String[] args) throws Exception {
        Operation op = new OperationImpl();
        OperationProxy proxy = new OperationProxy(op);
        // serialize and send proxy to app B
        byte[] proxyBytes = serialize(proxy);
        // simulate sending the serialized proxy to App B
        AppB.receiveProxy(proxyBytes);
    }

    private static byte[] serialize(OperationProxy proxy) throws Exception {
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);
        oos.writeObject(proxy);
        return bos.toByteArray();
    }
}

// App B (receiver)
class AppB {
    public static void receiveProxy(byte[] proxyBytes) throws Exception {
        // deserialize proxy
        OperationProxy receivedProxy = (OperationProxy) deserialize(proxyBytes);
        receivedProxy.execute(); // will print "Executing operation"
    }

    private static Object deserialize(byte[] bytes) throws Exception {
        java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(bytes);
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bis);
        return ois.readObject();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        AppA.main(args);
    }
}