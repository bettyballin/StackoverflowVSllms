import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class FileIndexer {

    public static void main(String[] args) throws Exception {
        String directoryPath = "M:\\tests\\";
        Map<String, String> fileHashes = new HashMap<>();

        // Initial scan and store hashes
        indexDirectory(directoryPath, fileHashes);

        // Simulate changes and rescan
        Path addedFile = Paths.get(directoryPath, "newfile.txt");
        Files.createFile(addedFile); // Add a new file

        Path removedFile = Paths.get(directoryPath, "oldfile.txt");
        Files.deleteIfExists(removedFile); // Remove an existing file

        // Rescan to find changes
        Map<String, String> currentHashes = new HashMap<>();
        indexDirectory(directoryPath, currentHashes);

        // Compare hashes and print added/removed files
        for (String path : currentHashes.keySet()) {
            if (!fileHashes.containsKey(path)) {
                System.out.println("Added: " + path);
            }
        }

        for (String path : fileHashes.keySet()) {
            if (!currentHashes.containsKey(path)) {
                System.out.println("Removed: " + path);
            }
        }
    }

    private static void indexDirectory(String directoryPath, Map<String, String> fileHashes) throws Exception {
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    String hash = getFileChecksum(file);
                    fileHashes.put(file.getAbsolutePath(), hash);
                }
            }
        }
    }

    private static String getFileChecksum(File file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);

        byte[] byteArray = new byte[1024];
        int bytesCount;

        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }

        fis.close();

        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}