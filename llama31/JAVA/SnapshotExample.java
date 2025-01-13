import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SnapshotExample implements Serializable {
    private int state;

    public SnapshotExample(int state) {
        this.state = state;
    }

    public static void main(String[] args) throws Exception {
        // Create an instance and set its state
        SnapshotExample instance = new SnapshotExample(42);

        // Serialize the instance to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("snapshot.ser"))) {
            oos.writeObject(instance);
        }

        // Later, deserialize the instance from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("snapshot.ser"))) {
            SnapshotExample restoredInstance = (SnapshotExample) ois.readObject();
            System.out.println("Restored state: " + restoredInstance.state);
        }
    }
}