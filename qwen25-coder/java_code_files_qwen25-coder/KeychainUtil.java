import java.lang.String;
import java.io.*;

public class KeychainUtil {
    public static String getFromKeychain(String account, String service) throws Exception {
        Process process = new ProcessBuilder(
            "security", "find-generic-password", "-a", account, "-s", service, "-g"
        ).start();

        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0)
            throw new RuntimeException("Failed to retrieve credentials from keychain.");

        // The password is in the last line of the output, prefixed with "password: "
        String result = output.toString().trim().split("\n")[1];
        return result.substring(result.indexOf(":") + 2).replace("\"", "");
    }

    public static void main(String[] args) {
    }
}