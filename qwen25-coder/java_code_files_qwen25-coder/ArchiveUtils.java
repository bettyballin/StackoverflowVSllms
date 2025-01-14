import java.lang.String;
import java.io.*;
import java.util.zip.GZIPInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;

public class ArchiveUtils {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Example mount command (use with caution and ensure you have the necessary permissions)
        String mountCommand = "sudo mount -t cifs -o username=youruser,password=yourpassword //remote/share /mnt/point";
        ProcessBuilder pbMount = new ProcessBuilder("/bin/sh", "-c", mountCommand);
        pbMount.redirectErrorStream(true);

        Process proc = pbMount.start();
        printProcessOutput(proc.getInputStream());
        int exitCode = proc.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Mount command failed with code: " + exitCode);
        }

        // Untar using Java
        String tarGzFilePath = "/path/to/your/file.tar.gz";
        String destDirectory = "/mnt/point/destination";
        untar(tarGzFilePath, destDirectory);

        System.out.println("Process completed successfully");
    }

    private static void printProcessOutput(InputStream inputStream) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }

    private static void untar(String tarGzFilePath, String destDirectory) throws IOException {
        File tarGzFile = new File(tarGzFilePath);
        TarArchiveInputStream tarIn = new TarArchiveInputStream(new GZIPInputStream(new FileInputStream(tarGzFile)));
        TarArchiveEntry entry;

        while ((entry = tarIn.getNextTarEntry()) != null) {
            File destPath = new File(destDirectory, entry.getName());
            if (entry.isDirectory()) {
                destPath.mkdirs();
            } else {
                destPath.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(destPath);
                copy(tarIn, fos);
                fos.close();
            }
        }
        tarIn.close();
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}