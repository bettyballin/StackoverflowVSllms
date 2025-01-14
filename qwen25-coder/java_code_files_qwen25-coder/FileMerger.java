import java.lang.String;
import java.io.*;
public class FileMerger {
    public static void mergeFile(String directoryName, String fileName, int chunks) throws IOException {
        File outFile = new File(fileName);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile))) {
            for (int i = 0; i < chunks; i++) {
                File chunkFile = new File(directoryName + "/" + fileName + ".part" + i);
                byte[] buffer = new byte[(int) chunkFile.length()];
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(chunkFile))) {
                    bis.read(buffer, 0, buffer.length);
                    bos.write(buffer);
                }
            }
        }
    }

	public static void main(String[] args) {
	}
}