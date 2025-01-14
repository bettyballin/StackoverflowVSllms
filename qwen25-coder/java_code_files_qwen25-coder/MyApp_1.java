import java.io.*;
import java.net.*;
import javax.swing.*;

public class MyApp_1 {

    public void onModuleLoad() {
        try {
            URL url = new URL("http://localhost/getGuide"); // Adjust URL as needed
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder htmlContent = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                htmlContent.append(inputLine);
            }
            in.close();
            con.disconnect();

            // Display HTML content in a JFrame
            JFrame frame = new JFrame("HTML Content");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JEditorPane editorPane = new JEditorPane("text/html", htmlContent.toString());
            editorPane.setEditable(false);
            frame.getContentPane().add(new JScrollPane(editorPane));
            frame.setSize(800, 600);
            frame.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to receive guide content: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MyApp_1().onModuleLoad();
    }
}