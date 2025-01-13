import org.apache.hadoop.hbase.util.Bytes;

public class RowKeyGenerator {
    // Example values for timestamp, logEventType, and logSource
    private static long timestamp = System.currentTimeMillis();
    private static String logEventType = "ExampleEventType";
    private static String logSource = "ExampleLogSource";

    // Row-key design
    public static byte[] generateRowKey(long timestamp, String logEventType, String logSource) {
        return Bytes.add(
            Bytes.toBytes(Long.MAX_VALUE - timestamp), // inverted timestamp
            Bytes.toBytes(logEventType), // log event type
            Bytes.toBytes(logSource) // log source
        );
    }

    public static void main(String[] args) {
        byte[] rowKey = generateRowKey(timestamp, logEventType, logSource);
        System.out.println("Generated Row Key: " + Bytes.toStringBinary(rowKey));
    }
}