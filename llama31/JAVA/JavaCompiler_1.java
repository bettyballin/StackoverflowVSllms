import java.io.File;
import java.io.IOException;

public class JavaCompiler_1_1 {
    public static void main(String[] args) {
        JavaCompiler_1 compiler = new JavaCompiler_1();
        File sourceFile = new File("path_to_your_java_file.java"); // replace with your java file
        compiler.compile(sourceFile);
    }

    public void compile(File sourceFile) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("javac", "-d", System.getProperty("java.io.tmpdir"), sourceFile.getAbsolutePath());
            Process process = processBuilder.start();
            int compilationResult = process.waitFor();
            System.out.println("Compilation result: " + compilationResult);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error compiling java file: " + e.getMessage());
        }
    }
}