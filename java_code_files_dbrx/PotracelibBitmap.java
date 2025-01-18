import com.sun.jna.Structure;
import com.sun.jna.Pointer;
import com.sun.jna.Memory;

public class PotracelibBitmap extends Structure {
    public int w; // width, in pixels
    public int h; // height, in pixels
    public int dy; // scanline offset in words
    public Pointer map_ptr; // pixel data pointer, dy * h longs/words

    // Helper method to access map as a long array for easier manipulation and use.
    public long[] getMap() {
        if (map_ptr == null) {
            return new long[0]; // or throw an exception, depending on your needs.
        }
        long length = ((long) h * Math.abs((long) dy)) / Long.BYTES;
        Memory m = new Memory(length);
        m.write(0, map_ptr.getByteArray(0, (int)length), 0, (int)length);
        return m.getLongArray(0, (int) length);
    }

    public static void main(String[] args) {
    }
}