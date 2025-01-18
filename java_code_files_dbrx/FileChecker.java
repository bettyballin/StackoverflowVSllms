import java.io.*;

public class FileChecker {
    public boolean doesFileExist(String pathToFile) {
        File f = new File(pathToFile);
        return (f.exists() && !f.isDirectory());
    }

    public static void main(String[] args) {
        // Useful for debugging purposes, replace <filepath> with actual file location
        // e.g., "\\remotemachine\dir\MyFileHere.txt" or your mapped K:\ drive path
        FileChecker checker = new FileChecker();
        System.out.println("Does the file exist? " + checker.doesFileExist("<filepath>"));
    }
}