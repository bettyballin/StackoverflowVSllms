import java.lang.String;
import java.io.*;
import javax.swing.*;

public class LoadMap extends JFrame {
    public LoadMap() throws IOException {
        FileInputStream fIn = new FileInputStream("map.srn");
        BufferedReader rd = null;
        try {
            InputStreamReader isr = new InputStreamReader(fIn, "US-ASCII");
            rd = new BufferedReader(isr);
            StringBuffer map = new StringBuffer();
            JTextArea mapArea = new JTextArea(15, 50);

            int c;
            while ((c = rd.read()) != -1) {
                // converts byte values to characters
                char character = (char) c;
                // appends the character to a StringBuffer
                map.append(character);
            }
            mapArea.setText(map.toString());
            mapArea.setEditable(false);
            add(mapArea);
        } finally {
            if (rd != null) {
                rd.close();
            }
        }
        pack();
        setVisible(true);
    }

	public static void main(String[] args) {
	}
}