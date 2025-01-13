import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Compiler {
    public static void main(String[] args) throws Exception {
        String source = "public class Test { public static void main(String[] args) { System.out.println(\"Hello, World!\"); } }";
        String className = "Test";
        String methodName = "main";

        // Create a new Java compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            System.out.println("No Java compiler found.");
            return;
        }

        // Create a temporary file for the source code
        File sourceFile = File.createTempFile(className, ".java");
        sourceFile.deleteOnExit();

        // Write the source code to the temporary file
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write(source);
        }

        // Compile the source code
        int compilationResult = compiler.run(null, null, null, sourceFile.getAbsolutePath());
        if (compilationResult != 0) {
            System.out.println("Compilation failed.");
            return;
        }

        // Load the compiled class
        URLClassLoader classLoader = new URLClassLoader(new URL[] { new File(System.getProperty("java.io.tmpdir")).toURI().toURL() });
        Class<?> clazz = classLoader.loadClass(className);

        // Run the specified method
        Method method = clazz.getMethod(methodName, String[].class);
        method.invoke(null, (Object) new String[0]);
    }
}