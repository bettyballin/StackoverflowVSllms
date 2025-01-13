/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_611 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String string;
        String[] stringArray2 = new String[]{"ssh", "-t", "user@host", "cd /path/to/somewhere; exec $SHELL -l"};
        Process process = Runtime.getRuntime().exec(stringArray2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        bufferedReader.close();
        process.waitFor();
    }
}
