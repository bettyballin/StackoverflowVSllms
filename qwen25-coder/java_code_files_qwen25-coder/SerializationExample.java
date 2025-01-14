import java.lang.String;
import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        try {
            // Create an object of SomeClass
            SomeClass obj = new SomeClass();

            // Serialize the object to a file
            FileOutputStream fos = new FileOutputStream("objSer.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class SomeClass implements Serializable {
        private int x = 2;
        private String y = "hello";
    }
}