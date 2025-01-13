import java.lang.String;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.FloatBuffer;

public class Main_327 {
    public static void main(String[] args) {
        // Create a FloatBuffer
        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
        // Put some data in the buffer
        for (int i = 0; i < 10; i++) {
            floatBuffer.put((float) i);
        }
        // Flip the buffer so it's ready for reading
        floatBuffer.flip();

        // Create a FileOutputStream
        try (FileOutputStream fos = new FileOutputStream("floatbuffer.bin")) {
            // Get the underlying array from the buffer
            float[] array = new float[floatBuffer.remaining()];
            floatBuffer.get(array);

            // Write the array to the file
            for (float f : array) {
                fos.write(Float.floatToIntBits(f));
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}