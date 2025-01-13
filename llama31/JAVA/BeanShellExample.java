import java.lang.String;
import bsh.*;

public class BeanShellExample {
    public static void main(String[] args) throws Exception {
        // Define a BeanShell script as a string
        String source = "System.out.println(\"Hello, World!\");";

        // Create an instance of the BeanShell interpreter
        Interpreter interpreter = new Interpreter();
        
        // Evaluate the script
        interpreter.eval(source);
    }
}