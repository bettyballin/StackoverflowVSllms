import java.lang.String;
import java.io.*;

public class ObjectSizeFetcher_1 {

    public static long getObjectSize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        
        // Write the object to the ObjectOutputStream
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();  // Ensure all data is flushed
        objectOutputStream.close();

        // Get the byte array and return its length, which represents the object size in bytes
        return byteArrayOutputStream.size();
    }

    public static void main(String[] args) throws IOException {
        MyObject myObject = new MyObject(); // Assume you have your class defined

        long sizeInBytes = getObjectSize(myObject);
        System.out.println("Approximate object size: " + sizeInBytes + " bytes");
    }
}

// Example simple class to serialize
class MyObject implements Serializable {
    private int id;
    private String name;

    public MyObject() {
        this.id = 1;
        this.name = "Example";
    }
}