import java.lang.String;
import java.io.*;
public class WriteUTF {
    public static void main(String[] args) throws Exception{
        // The String with two chinese characters
        String shanghaiStr = "上海";
        boolean append = true;

        FileOutputStream fos = new FileOutputStream("ShangHai.txt",append);

        // Wrapping the outputstream in an OutputStreamWriter to ensure correct encoding
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));

        // Writing string using write method inherited from OutputStreamWriter
        out.write(shanghaiStr);

        out.close();  // Remember to close the writer and streams after usage
    }
}