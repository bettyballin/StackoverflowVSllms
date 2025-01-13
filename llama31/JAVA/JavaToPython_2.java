import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class JavaToPython_2_2 {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import nltk");
        PyObject result = interpreter.eval("nltk.word_tokenize('Hello, world!')");
        System.out.println(result.toString());
    }
}