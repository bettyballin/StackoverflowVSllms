import java.lang.String;
import java.io.*;

public class ObjectSizeCalculator {
    public static long getObjectSize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.flush();
        return bos.toByteArray().length;
    }

	public static void main(String[] args) {
	}
}