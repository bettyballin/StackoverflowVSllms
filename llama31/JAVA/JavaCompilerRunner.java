import java.io.File;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JavaCompilerRunner {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            System.err.println("No Java compiler found.");
            return;
        }

        File sourceFile = new File("path_to_your_java_file.java"); // replace with your java file
        int compilationResult = compiler.run(null, null, null, "-d", System.getProperty("java.io.tmpdir"), sourceFile.getAbsolutePath());

        if (compilationResult == 0) {
            System.out.println("Compilation successful.");
        } else {
            System.out.println("Compilation failed.");
        }
    }
}