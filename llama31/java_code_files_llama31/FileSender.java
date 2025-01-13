/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JFileChooser;

public class FileSender {
    private static final int PORT = 8000;

    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket("localhost", 8000);
        JFileChooser jFileChooser = new JFileChooser();
        int n = jFileChooser.showOpenDialog(null);
        if (n == 0) {
            int n2;
            File file = jFileChooser.getSelectedFile();
            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] byArray = new byte[1024];
            long l = 0L;
            long l2 = file.length();
            while ((n2 = fileInputStream.read(byArray)) != -1) {
                outputStream.write(byArray, 0, n2);
                int n3 = (int)((float)(l += (long)n2) / (float)l2 * 100.0f);
                System.out.println("Sending file... (" + n3 + "%)");
            }
            fileInputStream.close();
            outputStream.close();
        }
        socket.close();
    }
}
