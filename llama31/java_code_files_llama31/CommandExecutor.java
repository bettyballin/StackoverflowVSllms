/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {
    public static String execute(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(string);
            process.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string2 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                stringBuilder.append(string2 + "\n");
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(CommandExecutor.execute("echo Hello World"));
    }
}
