import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter_1 {
    public static List<File> splitFile(File file, int pieceSize) throws IOException {
        List<File> chunkFiles = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[pieceSize];
            String baseName = file.getName();
            int count;
            while ((count = inputStream.read(buffer)) > 0) {
                File outputChunkFile = new File(file.getParent(), getSplitFileName(baseName, chunkFiles.size()));
                try (OutputStream outputStream = new FileOutputStream(outputChunkFile)) {
                    outputStream.write(buffer, 0, count); // Write the piece
                }
                chunkFiles.add(outputChunkFile);
            }
        }
        return chunkFiles;
    }

    private static String getSplitFileName(String baseName, int partNumber) {
        return String.format("%s.%d", baseName, partNumber + 1);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/path/to/file.zip");
        List<File> splitFiles = splitFile(file, 1024 * 1024); // Split into 1 MB pieces
        System.out.println("Number of files created: " + splitFiles.size());
    }
}