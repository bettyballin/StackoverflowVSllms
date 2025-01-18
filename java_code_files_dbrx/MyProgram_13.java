import java.awt.Font;
import java.awt.Graphics;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyProgram extends JPanel {

    @Override
    protected void paintComponent(Graphics gfx) {
        super.paintComponent(gfx);

        // Existing code starts here
        String myText = "Hello, Unicode \u0CA0\u203F\u21FC!";

        // Get the default encoding
        String enc = System.getProperty("file.encoding");

        Font font = new Font("Arial", Font.PLAIN, 14); // Adjust this to your needs.
        gfx.setFont(font);

        // If you need UTF-8 encoding.
        try {
            byte[] ptext = myText.getBytes("UTF-8");
            String value = new String(ptext, "UTF-8");
            gfx.drawString(value, 10, 25);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // Existing code ends here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Unicode Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyProgram());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}