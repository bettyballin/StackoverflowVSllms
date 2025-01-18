import java.lang.String;
import com.sun.jna.*;
/**
 * Native bindings of the InpOut32 DLL functions:
 */
public class InpOut32LibApi {

    public interface InpOutLib extends Library {
        // Function signatures are based on C++ documentation at <https://logix4u.net/Legacy_Ports/Parallel_Port/Inpo...>
        /**
         * Write a byte to I/O port (Output)
         */
        void Out32(Library lib, int adr, int data);
    }

    public static void main(String[] args) {
    }
}