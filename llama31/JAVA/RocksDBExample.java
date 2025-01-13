import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

public class RocksDBExample {
    public static void main(String[] args) throws RocksDBException {
        // Initialize RocksDB
        Options options = new Options();
        options.createIfMissing(true);
        RocksDB db = RocksDB.open(options, "/path/to/db");

        // Put a key-value pair
        db.put("key".getBytes(), "value".getBytes());

        // Get the value for a key
        byte[] value = db.get("key".getBytes());
        System.out.println(new String(value));

        // Close the database
        db.close();
        options.close();
    }
}