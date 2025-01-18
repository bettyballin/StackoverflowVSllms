import javax.tools.*;
import java.lang.reflect.Method;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class RuntimeCompilation {
  public static void main(String[] args) throws Exception {
    // Create a Java file object with the source code
    String className = "HelloWorld";
    String sourceCode = "public class HelloWorld {\n" +
                        "   public static String hello() {\n" +
                        "      return \"Hello, world!\";\n" +
                        "   }\n" +
                        "}\n";
    JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

    // Create a temp file and write the source code into it
    Path pathToOutputFile = Files.createTempFile("generated-", ".java");
    String absolutePath = pathToOutputFile.toAbsolutePath().toString();
    Files.write(pathToOutputFile, sourceCode.getBytes());

    // Set options for compilation process
    List<String> options = Arrays.asList("-encoding", "UTF-8");
    StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
    File file = new File(absolutePath);
    Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(file));

    // Compile the source code and generate bytecode
    JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, fileManager, null, options, null, compilationUnits);
    boolean success = compilationTask.call();

    // Load the generated class and invoke its method
    if (success) {
      URLClassLoader classLoader = URLClassLoader.newInstance(
          new URL[]{file.getParentFile().toURI().toURL()},
          RuntimeCompilation.class.getClassLoader()
      );
      Class<?> helloWorld = classLoader.loadClass("HelloWorld");
      Method helloMethod = helloWorld.getDeclaredMethod("hello");
      String message = (String) helloMethod.invoke(null);
      System.out.println(message);
    } else {
      throw new Exception("Failed to compile source code");
    }
  }
}