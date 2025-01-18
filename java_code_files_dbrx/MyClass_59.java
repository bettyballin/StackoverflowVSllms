import java.io.File;

public class MyClass {
    public static void callVbScript(String scriptName) throws Exception {
        String pathToVB = "C:\\Your\\Path\\To.vbs"; // Update with real path and filename in quotes
        ProcessBuilder pb = new ProcessBuilder("wscript", pathToVB); // Use wscript for .vbs and cscript for .vbs files without visual interface
        pb.directory(new File(".")); // Specify start directory - here current folder
        Process p = pb.start();
    }
}