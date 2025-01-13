import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main_50_50 {

    public static void main(String[] args) {
        String filePath = "path/to/your/very_large_file.txt";
        try {
            System.out.println(readLastLineEfficient(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Efficiently reads the last line of a text file by seeking to the end of the file
     * and backtracking to the first newline character.
     *
     * @param filePath the path to the text file
     * @return the last line of the text file
     * @throws IOException if an I/O error occurs
     */
    public static String readLastLineEfficient(String filePath) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(new File(filePath), "r")) {
            long fileSize = raf.length();
            int lastChar;
            int newlinePosition = -1;
            for (long position = fileSize - 1; position >= 0; position--) {
                raf.seek(position);
                lastChar = raf.read();
                if (lastChar == '\n') {
                    // Found the last newline character
                    newlinePosition = (int) position;
                    break;
                }
            }
            if (newlinePosition == -1) {
                // No newline character found, the whole file is the last line
                raf.seek(0);
                return raf.readLine();
            } else {
                raf.seek(newlinePosition + 1);
                return raf.readLine();
            }
        }
    }
}