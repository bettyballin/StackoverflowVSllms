import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.security.AccessControlException;

public class MyClass {
    private String name;
    private int score;

    public void writeToFile() {
        try {
            File file = new File(System.getProperty("user.home") + File.separator + "highscores.txt");
            PrintWriter output = new PrintWriter(file);
            output.print(name + " " + score);
            output.close();
            System.out.println("Data written successfully to " + file.getAbsolutePath());
        } catch (AccessControlException e) {
            System.err.println("Permission denied. Cannot write to the specified location.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}