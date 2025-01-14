import java.lang.String;
import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;

public class InMemoryCompiler {
    public static void main(String[] args) throws Exception {
        // Define the source code for the class to compile.
        String className = "Test";
        String sourceCode = 
            "public class Test {\n" +
            "    public String sayHello() { return \"Hello, World!\"; }\n" +
            "}\n";
    
        // Create a Java compiler.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        // Prepare Java source file in memory.
        JavaFileObject sourceFile = new InMemoryJavaFileObject(className, sourceCode);
        
        // Prepare in-memory output manager.
        InMemoryJavaFileManager fileManager = new InMemoryJavaFileManager(compiler.getStandardFileManager(null, null, null));
    
        // Compile the Java source in memory.
        Boolean success = compiler.getTask(null, fileManager, null, null, null, Arrays.asList(sourceFile)).call();
        if (!success) {
            throw new RuntimeException("Could not compile code");
        }
    
        // Load and instantiate compiled class.
        ClassLoader classLoader = fileManager.getClassLoader(null);
        Class<?> clazz = classLoader.loadClass(className);
    
        Object instance = clazz.getDeclaredConstructor().newInstance();
    
        // Find the predefined method and call it.
        java.lang.reflect.Method method = clazz.getMethod("sayHello");
        String result = (String) method.invoke(instance);
        System.out.println(result);  // => Hello, World!
    }

    static class InMemoryJavaFileObject extends SimpleJavaFileObject {
        private final String code;

        InMemoryJavaFileObject(String className, String code) {
            super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

    static class InMemoryJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        private InMemoryClassFileObject classFileObject;

        protected InMemoryJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className,
                                                   JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            classFileObject = new InMemoryClassFileObject(className, kind);
            return classFileObject;
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            return new InMemoryClassLoader(classFileObject);
        }
    }

    static class InMemoryClassFileObject extends SimpleJavaFileObject {
        private ByteArrayOutputStream baos;

        InMemoryClassFileObject(String className, Kind kind) {
            super(URI.create("bytes:///" + className), kind);
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            baos = new ByteArrayOutputStream();
            return baos;
        }

        public byte[] getBytes() {
            return baos.toByteArray();
        }
    }

    static class InMemoryClassLoader extends ClassLoader {
        private final InMemoryClassFileObject classFileObject;

        public InMemoryClassLoader(InMemoryClassFileObject classFileObject) {
            this.classFileObject = classFileObject;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] bytes = classFileObject.getBytes();
            return defineClass(name, bytes, 0, bytes.length);
        }
    }
}