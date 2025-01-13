/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.FloatBuffer;

public class Main_327 {
    public static void main(String[] stringArray) {
        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
        for (int i = 0; i < 10; ++i) {
            floatBuffer.put(i);
        }
        floatBuffer.flip();
        try (FileOutputStream fileOutputStream = new FileOutputStream("floatbuffer.bin");){
            float[] fArray = new float[floatBuffer.remaining()];
            floatBuffer.get(fArray);
            for (float f : fArray) {
                fileOutputStream.write(Float.floatToIntBits(f));
            }
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
