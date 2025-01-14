import java.lang.String;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class ProcessNameChanger {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load("c", CLibrary.class);
        int prctl(int option, String arg2);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.prctl(15 /* PR_SET_NAME */, "MyProgram");
    }
}