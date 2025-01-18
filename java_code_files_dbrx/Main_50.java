import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // To retrieve EUID
        Process getUidProc = new ProcessBuilder("id", "-u").start();
        BufferedReader stdout = new BufferedReader(new InputStreamReader(getUidProc.getInputStream()));
        String uidStr = stdout.readLine().trim();
        stdout.close();
        int userEuid = Integer.parseInt(uidStr);

        // To convert EUID to username via JNI
        Process getUsernameProc = Runtime.getRuntime().exec(
            new String[] {
                "bash",
                "-c",
                String.format(
                    "printf $'%s\\n' '%s'",
                    "",
                    String.format(
                        "export UID=%d; printf $(id -un)",
                        userEuid
                    )
                )
            }
        );
        BufferedReader nameStdout = new BufferedReader(new InputStreamReader(getUsernameProc.getInputStream()));
        String nameStr = nameStdout.readLine().trim();
        nameStdout.close();

        System.out.println("Username: " + nameStr);
    }
}