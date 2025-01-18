import java.lang.String;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JarCopyFile {
    public void copyFileFromJarToFilesystem(String jarFilePath, String packagePathInsideJar,
                                            String externalTargetPath) throws IOException {
        // Get input stream from file inside JAR
        InputStream is = getClass().getResourceAsStream(packagePathInsideJar);
        if (is == null) {
          throw new FileNotFoundException("file " + packagePathInsideJar + " not found in JAR");
        }
        // Write to an external file, using try-with-resources for safe closing
        try(OutputStream outputStream = Files.newOutputStream(Paths.get(externalTargetPath))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

	public static void main(String[] args) {
	}
}