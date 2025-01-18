import java.lang.String;

public class BreakpointFromSourceFile {
    // Pseudocode for setting breakpoints from source files
    public static void main(String[] args) {
        try {
            // Call function in third party DLL
        } catch(Exception e) {
            // If exception occurs, Visual Studio will pause execution here when set to "break on throw"
            // From this point you can check the call stack, view variables, etc. for debugging purposes
        }
    }
}