import java.util.List;
import com.sun.jna.Structure;
import com.sun.jna.Pointer;
import java.util.Arrays;

public class Potrace_bitmap_t extends Structure {
    public int w;   // width and height, in pixels
    public int h;
    public int dy;  // scanline offset in words
    public Pointer map; // pixel data, dy*h words

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("w", "h", "dy", "map");
    }

    public static void main(String[] args) {
    }
}