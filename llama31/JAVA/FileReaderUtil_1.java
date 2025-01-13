import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderUtil_1_1 {
    private static int readSoleInteger(String path) throws IOException {
        try (Scanner scanner = new Scanner(new File(path))) {
            return scanner.nextInt();
        }
    }

    public static void main(String[] args) {
    }
}