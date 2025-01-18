public class FileNameUpdater {
    // Let 'filename' be oldName.jpg, change it like this every time a new image arrives with the same name:
    String newFileName = System.nanoTime() + "_oldName.jpg"; // generates a unique prefix and concatenates it with the filename.
    public static void main(String[] args) {
    }
}