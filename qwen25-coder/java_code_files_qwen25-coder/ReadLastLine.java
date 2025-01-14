import java.lang.String;
import java.io.*;

public class ReadLastLine {
    public static void main(String[] args) {
        String filePath = "path/to/your/largefile.txt";
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            long fileLength = raf.length() - 1;
            StringBuilder sb = new StringBuilder();
            for(long filePointer = fileLength; filePointer >= 0; filePointer--){
                raf.seek(filePointer);
                int readByte = raf.readByte();

                if(readByte == '\n') {
                    if(sb.length() > 0) {
                        break;
                    }
                } else {
                    sb.append((char) readByte);
                }
            }
            String lastLine = sb.reverse().toString();
            System.out.println("Last line: " + lastLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}