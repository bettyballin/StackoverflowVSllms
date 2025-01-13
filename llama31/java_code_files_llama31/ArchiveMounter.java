/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArchiveMounter {
    public static void main(String[] stringArray) throws Exception {
        String string;
        ProcessBuilder processBuilder = new ProcessBuilder("mount", "-t", "cifs", "-o", "username=...");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        int n = process.waitFor();
        if (n != 0) {
            System.out.println("Mount command failed with exit code " + n);
        }
        ProcessBuilder processBuilder2 = new ProcessBuilder("tar", "xzf", "...");
        processBuilder2.redirectErrorStream(true);
        Process process2 = processBuilder2.start();
        bufferedReader = new BufferedReader(new InputStreamReader(process2.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        int n2 = process2.waitFor();
        if (n2 != 0) {
            System.out.println("Tar command failed with exit code " + n2);
        }
    }
}
