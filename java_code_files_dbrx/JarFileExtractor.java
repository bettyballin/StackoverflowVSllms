import java.lang.String;
public class JarFileExtractor {
    JarCopyFile jarCopyFile = new JarCopyFile();
    String internalResourcePath = "com/test/io/test.txt"; // Change as required in your case

    public JarFileExtractor() {
        jarCopyFile.copyFileFromJarToFilesystem("/path/to/your/my_application.jar",
            internalResourcePath, "/path/where/you/want/save/the/file");
    }

    public static void main(String[] args) {
    }
}