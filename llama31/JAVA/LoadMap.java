import java.lang.String;
import java.io.*;
import javax.swing.*;

public class LoadMap extends JFrame {
    public LoadMap() throws IOException {
        FileInputStream fIn = new FileInputStream("map.srn");
        BufferedReader rd = new BufferedReader(new InputStreamReader(fIn, "US-ASCII"));
        StringBuilder map = new StringBuilder();
        JTextArea mapArea = new JTextArea(15, 50);

        try {
            int c;
            while ((c = rd.read()) != -1) {
                map.append((char) c);
            }
        } finally {
            if (rd != null) {
                rd.close();
            }
        }
        mapArea.setText(map.toString());
        mapArea.setEditable(false);
        add(mapArea);
        pack();
        setVisible(true);
    }

	public static void main(String[] args) {
	}
}