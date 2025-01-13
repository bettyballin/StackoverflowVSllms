import java.lang.String;
import java.io.File;

public class Main_738 {
    public static void main(String[] args) {
        File file = new File("non_existent_file.txt");
        System.out.println(file.delete());  // prints: false
    }
}