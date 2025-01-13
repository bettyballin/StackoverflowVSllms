/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SnapshotExample
implements Serializable {
    private int state;

    public SnapshotExample(int n) {
        this.state = n;
    }

    public static void main(String[] stringArray) throws Exception {
        SnapshotExample snapshotExample = new SnapshotExample(42);
        try (Closeable closeable = new ObjectOutputStream(new FileOutputStream("snapshot.ser"));){
            ((ObjectOutputStream)closeable).writeObject(snapshotExample);
        }
        closeable = new ObjectInputStream(new FileInputStream("snapshot.ser"));
        try {
            SnapshotExample snapshotExample2 = (SnapshotExample)((ObjectInputStream)closeable).readObject();
            System.out.println("Restored state: " + snapshotExample2.state);
        }
        finally {
            ((ObjectInputStream)closeable).close();
        }
    }
}
