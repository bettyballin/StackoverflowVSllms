import java.io.*;
import javax.swing.*;

public class LoadMap_1_1 extends JFrame {
    public LoadMap_1() throws IOException {
        FileInputStream fIn = new FileInputStream("map.srn");
        BufferedReader rd = new BufferedReader(new InputStreamReader(fIn, "US-ASCII"));
        StringBuilder map = new StringBuilder();
        JTextArea mapArea = new JTextArea(15, 50);

        try {
            String line;
            while ((line = rd.readLine()) != null) {
                map.append(line).append("\n");
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
        SwingUtilities.invokeLater(() -> {
            try {
                new LoadMap_1();
            } catch (IOException e) {
                System.err.println("Error loading map: " + e.getMessage());
            }
        });
    }
}