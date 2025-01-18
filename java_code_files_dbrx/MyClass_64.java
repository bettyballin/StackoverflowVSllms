import java.io.*;

public class MyClass {
    public static void main(String[] args) {
        // Write data
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("state.bin"))) {
            byte[] stateData = new byte[1024]; // your 1kb data here
            oos.writeObject(stateData);
        } catch (IOException e) { /* handle exception */ }

        // Read data
        byte[] readStateData;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("state.bin"))) {
            readStateData = (byte[]) ois.readObject();
        } catch (ClassNotFoundException | IOException e) { /* handle exception */ }
    }
}