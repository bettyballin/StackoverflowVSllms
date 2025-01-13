import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main_370 {
    private String name;
    private int score;

    public void writeToFile() {
        try {
            // Request permission to write to the file
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    try {
                        File file = new File("highscores.txt");
                        FileWriter writer = new FileWriter(file);
                        writer.write(name + " " + score);
                        writer.close();
                    } catch (IOException e) {
                        System.err.println("Unable to write to file");
                    }
                    return null;
                }
            });
        } catch (AccessControlException e) {
            System.err.println("Permission denied");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.name = "John";
        main.score = 100;
        main.writeToFile();
    }
}