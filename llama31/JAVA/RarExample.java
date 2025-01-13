import java.lang.String;
import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RarExample {
    public static void main(String[] args) throws IOException {
        File rarFile = new File("example.rar");
        File destDir = new File("extracted");

        Archive archive = new Archive(rarFile);
        for (FileHeader fileHeader : archive.getFileHeaders()) {
            File destFile = new File(destDir, fileHeader.getFileNameString());
            FileOutputStream fos = new FileOutputStream(destFile);
            archive.extractFile(fileHeader, fos);
            fos.close();
        }
    }
}