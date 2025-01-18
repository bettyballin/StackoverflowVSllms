public class MyProgram {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("echo", "Hello World!");
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
    }
}