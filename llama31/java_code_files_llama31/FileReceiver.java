/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;

public class FileReceiver {
    private static final int PORT = 8000;

    public static void main(String[] stringArray) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Save file");
        int n = jFileChooser.showSaveDialog(null);
        if (n == 0) {
            int n2;
            File file = jFileChooser.getSelectedFile();
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] byArray = new byte[1024];
            long l = 0L;
            while ((n2 = inputStream.read(byArray)) != -1) {
                fileOutputStream.write(byArray, 0, n2);
                int n3 = (int)((float)(l += (long)n2) / (float)file.length() * 100.0f);
                System.out.println("Receiving file... (" + n3 + "%)");
            }
            fileOutputStream.close();
            inputStream.close();
        }
        socket.close();
        serverSocket.close();
    }
}
