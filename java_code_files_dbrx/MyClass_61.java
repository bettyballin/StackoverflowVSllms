import java.io.*;
import java.util.UUID;

public class MyClass {

    public static byte[] byteArray(UUID uuid) throws IOException {
        long lsb = uuid.getLeastSignificantBits();
        long msb = uuid.getMostSignificantBits();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeLong(lsb);
        dos.writeLong(msb);
        dos.flush();

        byte[] data = bos.toByteArray();
        return data;
    }
}