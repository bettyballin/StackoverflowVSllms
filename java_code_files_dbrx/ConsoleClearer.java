import java.lang.String;
public class ConsoleClearer {
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os != null && os.contains("Windows")) {
                // Windows...
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                // Unix/Linux based approach to clear console
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (final Exception e) {
            System.out.println("\nERROR!!!\n" + e);
            // Print your custom exception or error message here
        }
    }
    public static void main(String[] args) {
    }
}