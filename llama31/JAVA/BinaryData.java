import java.io.File;
import java.io.IOException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

public class BinaryData {
    private byte[] data;

    public BinaryData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public static void main(String[] args) throws IOException {
        // Create a sample byte array
        byte[] myByteArray = {1, 2, 3, 4, 5};

        // Store an object with a binary field
        ObjectContainer container = Db4oEmbedded.openFile("mydb.db4o");
        BinaryData data = new BinaryData(myByteArray);
        container.store(data);
        container.close();

        // Retrieve an object with a binary field
        container = Db4oEmbedded.openFile("mydb.db4o");
        Query query = container.query();
        query.constrain(BinaryData.class);
        BinaryData result = (BinaryData) query.execute().next();
        byte[] retrievedData = result.getData();
        container.close();

        // Print the retrieved data
        for (byte b : retrievedData) {
            System.out.print(b + " ");
        }
    }
}