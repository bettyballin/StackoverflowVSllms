import javax.tools.*;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class InMemoryCompiler_1 {
    public static void main(String[] args) throws Exception {
        String className = "GeneratedClass";
        String sourceCode = 
            "public class " + className + " {\n" +
            "    public String sayHello() { return \"Hello, World!\"; }\n" +
            "}\n";

        // Create a JavaSourceFromString instance
        JavaFileObject file = new JavaSourceFromString(className, sourceCode);

        // Get the system compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // A file manager for managing sources and classes
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits =
                Arrays.asList(file);

        // Compile the source code
        JavaCompiler.CompilationTask task = compiler.getTask(
            System.err,
            fileManager,
            (Diagnostic<? extends JavaFileObject> diagnostic) -> {
                System.out.println(diagnostic.getMessage(null));
            },
            null, // options
            null, 
            compilationUnits);

        if (!task.call()) {
            throw new RuntimeException("Compilation failed");
        }

        InMemoryJavaCompiler inMemoryCompiler = new InMemoryJavaCompiler();
        byte[] bytecode = inMemoryCompiler.getClassBytes(className);

        ClassLoader classLoader = new SimpleClassLoader(className, bytecode);
        Class<?> clazz = classLoader.loadClass(className);
        Object instance = clazz.getDeclaredConstructor().newInstance();
        String result = (String) clazz.getMethod("sayHello").invoke(instance);
        System.out.println(result);

        if (fileManager != null)
            fileManager.close();
    }

    // JavaSourceFromString - a simple implementation of a JavaFileObject which obtains its content via supplied string
    static class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

    // InMemoryJavaCompiler - a simple implementation of a java compiler that compiles the provided class code in memory
    static class InMemoryJavaCompiler {
        private final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        private final MemoryJavaFileManager fileManager;

        InMemoryJavaCompiler() {
            this.fileManager = new MemoryJavaFileManager(compiler.getStandardFileManager(null, null, null));
        }

        byte[] getClassBytes(String className) throws Exception {
            JavaFileObject source = createSourceFromString(className);
            compiler.getTask(
                    null,
                    fileManager,
                    null,
                    null,
                    null,
                    Arrays.asList(source)).call();

            MemoryJavaClassObject memoryJavaClassObject = fileManager
                    .getClassObject(className);

            return memoryJavaClassObject.getBytes();
        }

        private JavaSourceFromString createSourceFromString(String name) {
            final StringBuilder sourceCode = new StringBuilder(
                    "public class " + name + " {" +
                    " public String sayHello() { return \"Hello, world!\"; }" +
                    "}");
            return new JavaSourceFromString(name, sourceCode.toString());
        }
    }

    // MemoryJavaFileManager - a JavaFileManager that stores compiled classes in memory
    static class MemoryJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        private final Map<String, MemoryJavaClassObject> classes = new HashMap<>();

        MemoryJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location,
                                                   String className,
                                                   JavaFileObject.Kind kind,
                                                   FileObject sibling) throws IOException {
            MemoryJavaClassObject classObject = new MemoryJavaClassObject(className, kind);
            classes.put(className, classObject);
            return classObject;
        }

        public MemoryJavaClassObject getClassObject(String name) {
            return classes.get(name);
        }
    }

    // MemoryJavaClassObject - a JavaFileObject that stores compiled bytecode in memory
    static class MemoryJavaClassObject extends SimpleJavaFileObject {
        protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        public MemoryJavaClassObject(String name, JavaFileObject.Kind kind) {
            super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
        }

        public byte[] getBytes() {
            return bos.toByteArray();
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            return bos;
        }
    }

    // SimpleClassLoader - a simple implementation of a class loader that loads classes from an in-memory byte array
    static class SimpleClassLoader extends ClassLoader {
        private final String className;
        private final byte[] classBytes;

        public SimpleClassLoader(String className, byte[] classBytes) {
            this.className = className;
            this.classBytes = classBytes;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name.equals(this.className)) {
                return defineClass(name, classBytes, 0, classBytes.length);
            }
            return super.findClass(name);
        }
    }
}