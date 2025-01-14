import java.io.File;

public class StorageHelper {
    // Example: Using getFilesDir to save a file
    File myFile;

    // Example: Using getCacheDir for cache files
    File cacheFile;

    public StorageHelper() {
        myFile = new File(getFilesDir(), "myfile.txt");
        cacheFile = new File(getCacheDir(), "cache.txt");
    }

    public File getFilesDir() {
        return new File(".");
    }

    public File getCacheDir() {
        return new File(".");
    }

    public static void main(String[] args) {
        StorageHelper helper = new StorageHelper();
    }
}