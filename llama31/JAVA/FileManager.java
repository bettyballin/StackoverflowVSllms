import java.lang.String;
import java.io.File;
import java.io.IOException;

public class FileManager {
    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    public void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
        }
    }

	public static void main(String[] args) {
	}
}