import java.lang.String;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class InMemoryCompiler {
    public static void main(String[] args) {
        String code = "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello, World!\"); } }";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler != null) {
            int compilationResult = compiler.run(null, null, null, code);
            if (compilationResult == 0) {
                System.out.println("Compilation successful");
            } else {
                System.out.println("Compilation failed");
            }
        } else {
            System.out.println("No Java compiler found");
        }
    }
}