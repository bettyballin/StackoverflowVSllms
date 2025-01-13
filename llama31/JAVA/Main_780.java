import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_780 {
    public static void main(String[] args) {
        try {
            File file = new File("hs_err_pidXXX.log");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("EXCEPTION_ACCESS_VIOLATION")) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}