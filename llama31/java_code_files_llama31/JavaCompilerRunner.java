/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JavaCompilerRunner {
    public static void main(String[] stringArray) {
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        if (javaCompiler == null) {
            System.err.println("No Java compiler found.");
            return;
        }
        File file = new File("path_to_your_java_file.java");
        int n = javaCompiler.run(null, null, null, "-d", System.getProperty("java.io.tmpdir"), file.getAbsolutePath());
        if (n == 0) {
            System.out.println("Compilation successful.");
        } else {
            System.out.println("Compilation failed.");
        }
    }
}
