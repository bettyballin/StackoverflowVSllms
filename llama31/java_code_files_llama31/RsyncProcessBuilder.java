/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class RsyncProcessBuilder {
    public static void main(String[] stringArray) throws Exception {
        String[] stringArray2 = new String[]{"c:/cygwin/bin/rsync.exe", "-verbose", "-r", "-t", "-v", "--progress", "-e", "ssh", "/cygdrive/c/Users/dokeeffe/workspace/jrsync/", "www.servername.net:/home/dokeeffe/rsync/"};
        String[] stringArray3 = new String[]{"PATH=c:/cygwin/bin;%PATH%"};
        File file = new File("c:/cygwin/bin/");
        ProcessBuilder processBuilder = new ProcessBuilder(stringArray2);
        processBuilder.environment().putAll(System.getenv());
        processBuilder.environment().put("PATH", stringArray3[0]);
        processBuilder.directory(file);
        Process process = processBuilder.start();
    }
}
