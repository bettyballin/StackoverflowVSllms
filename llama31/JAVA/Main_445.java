import org.ceph.io.CephClient;
import org.ceph.io.CephObject;

public class Main_445 {
    public static void main(String[] args) {
        // Create a Ceph client instance
        CephClient client = new CephClient("http://localhost:8080");

        // Create a new object
        CephObject obj = new CephObject("my-bucket", "my-key", "Hello, World!".getBytes());

        // Store the object
        client.putObject(obj);

        // Retrieve the object
        CephObject retrievedObj = client.getObject("my-bucket", "my-key");

        // Print the retrieved object's contents
        System.out.println(new String(retrievedObj.getData()));
    }
}