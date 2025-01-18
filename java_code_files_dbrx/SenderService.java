import java.io.*;

interface Operation {
    // interface methods (if any)
}

class OperationImpl_A implements Operation, Serializable {
    // implementation details
}

public class SenderService {
    public static void main(String[] args) throws IOException {
        Operation op = new OperationImpl_A();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(op);

        byte[] serializedObj = bos.toByteArray();
        streamToB(serializedObj); // Send bytes to B over network or other means
    }

    public static void streamToB(byte[] data) {
        // code to send data to B
    }
}