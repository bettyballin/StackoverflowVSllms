import java.lang.String;
import jpype.PythonObject;

public class JavaToPython {
    public static void main(String[] args) {
        PythonObject python = PythonObject.getInstance();
        python.exec("import nltk");
        python.exec("result = nltk.word_tokenize('Hello, world!')");
        System.out.println(python.get("result"));
    }
}