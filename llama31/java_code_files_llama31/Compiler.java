/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Compiler {
    public static void main(String[] stringArray) throws Exception {
        String string = "public class Test { public static void main(String[] args) { System.out.println(\"Hello, World!\"); } }";
        String string2 = "Test";
        String string3 = "main";
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        if (javaCompiler == null) {
            System.out.println("No Java compiler found.");
            return;
        }
        File file = File.createTempFile(string2, ".java");
        file.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(file);){
            fileWriter.write(string);
        }
        int n = javaCompiler.run(null, null, null, file.getAbsolutePath());
        if (n != 0) {
            System.out.println("Compilation failed.");
            return;
        }
        URLClassLoader uRLClassLoader = new URLClassLoader(new URL[]{new File(System.getProperty("java.io.tmpdir")).toURI().toURL()});
        Class<?> clazz = uRLClassLoader.loadClass(string2);
        Method method = clazz.getMethod(string3, String[].class);
        method.invoke(null, new Object[]{new String[0]});
    }
}
