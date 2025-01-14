// Example of using Jython to run a Python script from Java
import org.python.util.PythonInterpreter;

public class RunPythonScript {
    public static void main(String[] args) {
        try (PythonInterpreter pi = new PythonInterpreter()) {
            pi.execfile("path/to/your_script.py");
        }
    }
}