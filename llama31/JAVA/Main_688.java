// Java code
import jnr.ffi.Library;

public interface YourLibrary {
    void yourMethod();
}

public class Main_688 {
    public static void main(String[] args) {
        YourLibrary lib = Library.loadLibrary(YourLibrary.class);
        lib.yourMethod();
    }
}