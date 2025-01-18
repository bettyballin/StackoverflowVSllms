import java.io.*;
import java.security.SecureRandom;

public class RandomlyFillBigFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        long fileSize = 1_000_000_000L; // set file size to your required value in bytes
        try (RandomAccessFile raf = new RandomAccessFile("bigfile.data", "rw")) {
            int bufferSize = 4096;
            byte[] randomBytes = new byte[bufferSize];
            long remainingLength = fileSize;
            while (remainingLength > 0) {
                long offset = (long)(Math.random() * remainingLength); // generate a random position in the file
                int sizeToWrite = Math.min(bufferSize, (int) (remainingLength - offset)); // do not write more than what is left from this point forward
                fillRandomBytes(sizeToWrite, randomBytes);
                raf.seek(offset); // set the file pointer to position 'offset' in the file
                if (raf.length() < offset + sizeToWrite) { // If writing at this offset will exceed current length of the file then expand it using setLength method
                    raf.setLength(offset + bufferSize);
                }
                raf.write(randomBytes, 0, sizeToWrite); // write data to the randomly decided position in the file
                remainingLength -= sizeToWrite; // reduce total amount of data left to be written by how much we wrote
            }
        }
    }

    private static void fillRandomBytes(int length, byte[] buffer) {
        if (length > buffer.length) throw new IllegalArgumentException("Buffer not long enough for the required bytes.");
        SecureRandom r = new SecureRandom(); // This ensures we get random bytes with a cryptographically strong generator
        r.nextBytes(buffer); // fill 'length' bytes from the buffer starting at 0 position in the buffer
    }
}