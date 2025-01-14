import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EPSConverter {
    public static void convertEPS(String inputFilePath, String outputFilePath) throws IOException {
        // Command to convert EPS to PNG using Ghostscript
        String[] command = {
                "gswin64c.exe",            // Use 'gs' on Unix-based systems
                "-dNOPAUSE",
                "-dBATCH",
                "-sDEVICE=pngalpha",      // or use 'jpeg' for JPEG output
                "-r300",                    // Resolution in DPI
                "-sOutputFile=" + outputFilePath,
                inputFilePath
        };

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        // Optionally, read the command output (useful for debugging)
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        try {
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Conversion successful.");
            } else {
                System.out.println("Conversion failed with exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Process interrupted", e);
        }
    }

    public static void main(String[] args) {
        try {
            convertEPS("input.eps", "output.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}