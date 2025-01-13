import java.lang.String;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class DynamicClassCreator {
    public static void main(String[] args) {
        String className = "MyDynamicClass";
        String code = "public class " + className + " { private String myProperty; public String getMyProperty() { return myProperty; } public void setMyProperty(String myProperty) { this.myProperty = myProperty; } }";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, className, code);

        if (compilationResult == 0) {
            System.out.println("Class created successfully!");
        } else {
            System.out.println("Compilation failed");
        }
    }
}