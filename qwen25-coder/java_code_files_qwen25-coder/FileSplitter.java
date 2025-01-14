import java.lang.String;
import java.io.*;
public class FileSplitter {
    public static void splitFile(File inputFile, int chunkSize) throws IOException {
        byte[] buffer = new byte[chunkSize];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))) {
            String fileName = inputFile.getName();
            int index = 0;
            while (true) {
                int bytesRead = bis.read(buffer);
                if (bytesRead == -1) break; // End of file.
                File outputFile = new File(fileName + ".part" + index++);
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile))) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
        }
    }

	public static void main(String[] args) {
	}
}