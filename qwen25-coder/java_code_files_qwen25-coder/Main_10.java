import java.io.File;

public class Main_10 {
    public static void main(String[] args) {
        try {
            // Get the path of the .class file
            String path = Main_10.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File directory = new File(path).getParentFile();
            
            // Print the directory
            System.out.println("Directory: " + directory.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}