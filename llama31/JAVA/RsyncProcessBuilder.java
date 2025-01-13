import java.io.File;
import java.lang.String;

public class RsyncProcessBuilder {
    public static void main(String[] args) throws Exception {
        String[] command = {"c:/cygwin/bin/rsync.exe", "-verbose", "-r", "-t", "-v", "--progress", "-e", "ssh", "/cygdrive/c/Users/dokeeffe/workspace/jrsync/", "www.servername.net:/home/dokeeffe/rsync/"};
        String[] envVars = {"PATH=c:/cygwin/bin;%PATH%"};
        File workingDir = new File("c:/cygwin/bin/");

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.environment().putAll(System.getenv());
        pb.environment().put("PATH", envVars[0]);
        pb.directory(workingDir);
        Process p = pb.start();
    }
}