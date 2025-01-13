import com.sun.jna.Library;
import com.sun.jna.Native;

public class MyCLibrary {
    // Define the interface for the C library
    public interface MyCLibraryInterface extends Library {
        MyCLibraryInterface INSTANCE = Native.loadLibrary("myclibrary", MyCLibraryInterface.class);

        void myCFunction();
    }

    public static void main(String[] args) {
        // Example usage
        MyCLibraryInterface.INSTANCE.myCFunction();
    }
}