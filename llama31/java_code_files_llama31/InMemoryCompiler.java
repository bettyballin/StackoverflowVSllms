/*
 * Decompiled with CFR 0.152.
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class InMemoryCompiler {
    public static void main(String[] stringArray) {
        String string = "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello, World!\"); } }";
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        if (javaCompiler != null) {
            int n = javaCompiler.run(null, null, null, string);
            if (n == 0) {
                System.out.println("Compilation successful");
            } else {
                System.out.println("Compilation failed");
            }
        } else {
            System.out.println("No Java compiler found");
        }
    }
}
