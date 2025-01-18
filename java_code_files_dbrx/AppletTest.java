import javax.swing.*;
import org.fest.swing.fixture.FrameFixture;
import java.awt.*;

public class AppletTest {

  private FrameFixture window; // the GUI under test

  public void setUp() {
    JApplet applet = new MyApplet();

    // create a frame for the applet and add it to the native peer hierarchy:
    JFrame frame = new JFrame("My Applet Test");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    frame.setSize(800, 600); // set desired dimensions or call pack()

    // create a fixture for the created JFrame:
    window = new FrameFixture(frame);
    window.show(); // display the frame to test GUI interaction
  }

  public void tearDown() {
    window.cleanUp();
  }

  public static void main(String[] args) {
  }
}

class MyApplet extends JApplet {
  public void init() {
    // initialization code
  }
}

// Minimal stub for FrameFixture to allow code to compile
class FrameFixture {
  public FrameFixture(JFrame frame) {
    // constructor code
  }

  public void show() {
    // show code
  }

  public void cleanUp() {
    // clean up code
  }
}