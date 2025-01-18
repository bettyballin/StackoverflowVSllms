import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.CRC32;

public class Main {
    public static void main(String[] args) {
        // Initializing size of the byte (unsigned char) array
        int byteArraySize = 256; // Modify this based on the desired length of your byte array
        int unsignedDataLength = byteArraySize; // Assuming unsignedDataLength is the same as byteArraySize

        // Initialize a ByteBuffer object to wrap around the data storage (byte[] buffer).
        ByteBuffer unsignedData = ByteBuffer.allocate(byteArraySize);

        Random random = new Random();

        // Fill up your unsignedData with unsigned integers using bitwise XOR operator "^" and fill method from Java stream.
        random.ints(0, 256) // Create a finite IntStream that generates random int values between 0 (inclusive) to 256 (exclusive)
            .limit(unsignedDataLength) // Limits the size of the integer array based on your desired length
            .forEach(i -> unsignedData.put((byte) ((i ^ 0x100) & 0xFF))); // Using bitwise XOR operator to convert signed byte into an equivalent representation of the unsigned value.

        // To compute a cyclic redundancy check (CRC) for this data, convert ByteBuffer object containing your byte array into bytes[] and perform CRC computation on them:
        byte[] byteArray = Arrays.copyOfRange(unsignedData.array(), 0, unsignedDataLength); // Convert to actual byte array
        int crc = calculateCRC(byteArray); // Perform CRC computation

        System.out.println("CRC: " + crc);
    }

    public static int calculateCRC(byte[] data) {
        // Perform CRC computation using CRC32
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return (int) crc32.getValue();
    }
}