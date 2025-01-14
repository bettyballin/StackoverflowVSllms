import java.lang.String;
import java.io.IOException;

public class PostScriptValidator {
    public static void main(String[] args) {
        String filePath = "path/to/yourfile.ps";
        ProcessBuilder pb = new ProcessBuilder("gs", "-dBATCH", "-dNOPAUSE", "-sDEVICE=nullpage", filePath);
        
        try {
            Process process = pb.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("PostScript file is valid.");
            } else {
                System.err.println("PostScript file is invalid. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}