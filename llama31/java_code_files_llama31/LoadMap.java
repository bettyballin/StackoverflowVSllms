/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LoadMap
extends JFrame {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LoadMap() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("map.srn");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)fileInputStream, "US-ASCII"));
        StringBuilder stringBuilder = new StringBuilder();
        JTextArea jTextArea = new JTextArea(15, 50);
        try {
            int n;
            while ((n = bufferedReader.read()) != -1) {
                stringBuilder.append((char)n);
            }
        }
        finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        jTextArea.setText(stringBuilder.toString());
        jTextArea.setEditable(false);
        this.add(jTextArea);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] stringArray) {
    }
}
