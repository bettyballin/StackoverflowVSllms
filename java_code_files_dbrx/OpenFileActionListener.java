import java.lang.String;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class OpenFileActionListener {
    public static void main(String[] args) {
        JButton openfile = new JButton("Open File");
        Data data = new Data(); // Assuming Data class providing getTextFieldContent method
        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = data.getTextFieldContent();  // retrieve the current value of text in display panel
                System.out.println("Retrieved content: " + text);  // do something with it (example: print it out for now)
            }
        });
    }
}

class Data {
    public String getTextFieldContent() {
        return "Sample Text";
    }
}