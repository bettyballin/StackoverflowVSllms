/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class FilePathStorage {
    private List<String> filePaths = new ArrayList<String>();

    public void addFilePath(String string) {
        this.filePaths.add(string);
    }

    public void removeFilePath(String string) {
        this.filePaths.remove(string);
    }

    public List<String> getFilePaths() {
        return this.filePaths;
    }

    public static void main(String[] stringArray) {
        FilePathStorage filePathStorage = new FilePathStorage();
        filePathStorage.addFilePath("/path/to/file1.txt");
        filePathStorage.addFilePath("/path/to/file2.txt");
        System.out.println(filePathStorage.getFilePaths());
        filePathStorage.removeFilePath("/path/to/file1.txt");
        System.out.println(filePathStorage.getFilePaths());
    }
}
