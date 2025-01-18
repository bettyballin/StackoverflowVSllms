import java.util.*;
import java.lang.reflect.*;
import javax.tools.*;
import java.io.StringWriter;
import java.net.URI;
import java.lang.invoke.*;

public class OnTheFlyCompiler
{
    public static void main(String[] args) throws Exception {
        String source = "public class Test {" +
                "       public static void evaluate() {" +
                "           System.out.println(\"In Evaluate method\"); " +
                "      }" +
                "}";

        // Compile the code using in-memory JavaCompiler
        Class<?> clazz = compile("Test", source);
        Method evlMethod = null;
        try { evlMethod = clazz.getDeclaredMethod("evaluate"); } catch (NoSuchMethodException e) {}

        if(evlMethod!=null){
            // Invoke the static method here!
            evlMethod.invoke(null);

            /* Or you can also use Java 8 reflection capability like this: */
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodType mt = MethodType.methodType(void.class);
            MethodHandle mh = lookup.findStatic(clazz, "evaluate", mt);
            mh.invokeExact();
        }
    }

    /* This is where actual compilation takes place */
    public static Class<?> compile(String className, String sourceCode) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        if (compiler == null){
            System.err.println("Unable to locate the tool provider.");
            return null;
        }

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StringWriter writer = new StringWriter();
        JavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        JavaFileObject compilationUnit = new SimpleJavaFileObject(
            URI.create("string:///" + className.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension),
            JavaFileObject.Kind.SOURCE) {
                @Override
                public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                    return sourceCode;
                }
        };

        boolean success = compiler.getTask(writer,
                fileManager, diagnostics, null, null,
                Collections.singletonList(compilationUnit)).call();

        if(!success) {
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics())
                System.err.println("Error on line " + diagnostic.getLineNumber() + ": " + diagnostic);
            return null;
        }

        try{
            fileManager.close();
            return Class.forName(className);
        } catch (Exception e) {
            return null;
        }
    }
}