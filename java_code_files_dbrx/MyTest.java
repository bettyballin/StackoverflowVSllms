import org.fest.swing.fixture.*;
import static org.junit.Assert.assertEquals;
import javax.swing.*;

public class MyTest {
    public static void main(String[] args) {
        // Test code using FEST Swing:
        FrameFixture frame = new FrameFixture(new MyApp()); // Create an instance of the application to test
        JButtonFixture button = frame.button("myButton");  // Identify a component by its name or property
        button.click(); // Execute UI actions on components, like click() on buttons
        assertEquals("correctText", frame.textBox("myTextBox").text());  // Compare expected and actual result
    }
}

class MyApp extends JFrame {
    public MyApp() {
        setName("myAppFrame");
        JButton myButton = new JButton("Button");
        myButton.setName("myButton");
        JTextField myTextBox = new JTextField();
        myTextBox.setName("myTextBox");
        add(myButton);
        add(myTextBox);
        pack();
        setVisible(true);
    }
}