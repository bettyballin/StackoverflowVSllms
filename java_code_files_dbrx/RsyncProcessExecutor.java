import java.lang.String;
import java.io.File;
import java.io.IOException;

public class RsyncProcessExecutor {
    String[] envVars = {
        "HOME=C:\\cygwin",
        "USER=dokeeffe",
        "PATH=c:/cygwin/bin;" + System.getenv("PATH")
    };

    File workingDir = new File("c:\\cygwin");

    Process process;

    public RsyncProcessExecutor() {
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(
                "rsync -rptvz /cygdrive/c/Users/dokeeffe/worksapce/jrsync/ www.servername.net:/home/dokeeffe/rsync/",
                envVars,
                workingDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RsyncProcessExecutor executor = new RsyncProcessExecutor();
    }
}