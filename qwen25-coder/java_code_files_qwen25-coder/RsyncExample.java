import java.lang.String;
import java.io.File;
import java.io.IOException;

public class RsyncExample {
    public static void main(String[] args) {
        try {
            File workingDir = new File("c:/cygwin/bin/");
            ProcessBuilder pb = new ProcessBuilder(
                "c:/cygwin/bin/rsync.exe",
                "-verbose", "-r", "-t", "-v", "--progress", "-e", "ssh",
                "/cygdrive/c/Users/dokeeffe/workspace/jrsync/",
                "www.servername.net:/home/dokeeffe/rsync/"
            );
            pb.environment().put("PATH", "c:/cygwin/bin;" + System.getenv("PATH"));
            pb.directory(workingDir);
            
            Process p = pb.start();
            // Start your stream reader threads here as usual for capturing the inputStream and errorStream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}