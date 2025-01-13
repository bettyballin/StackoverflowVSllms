/*
 * Decompiled with CFR 0.152.
 */
public class ShellExecutor {
    public static void main(String[] stringArray) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("open", "/folder name/toast.sh");
        processBuilder.start();
    }
}
