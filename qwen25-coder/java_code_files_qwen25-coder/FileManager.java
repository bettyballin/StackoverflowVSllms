import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<File> fileList = new ArrayList<>();

    // Method to add a file to the list
    public void addFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {  // Check if the file exists before adding
            fileList.add(file);
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }

    // Method to remove a file from the list
    public void removeFile(String filePath) {
        File fileToRemove = new File(filePath);
        fileList.removeIf(f -> f.getPath().equals(fileToRemove.getPath()));
    }

    // Method to get the list of files
    public List<File> getFileList() {
        return new ArrayList<>(fileList);  // Return a copy of the list to prevent external modification
    }

    // Example usage
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.addFile("/path/to/file1.txt");
        fileManager.addFile("/path/to/file2.txt");

        for (File file : fileManager.getFileList()) {
            System.out.println("File: " + file.getAbsolutePath());
        }

        fileManager.removeFile("/path/to/file1.txt");

        for (File file : fileManager.getFileList()) {
            System.out.println("Remaining File: " + file.getAbsolutePath());
        }
    }
}