import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Applet extends Canvas {
  private JSObject jsObject;

  public Applet() {
    jsObject = new JSObject();
  }

  public void paint(Graphics g) {
    // your visualization code here
  }

  public void updateData(String newData) {
    // update your visualization with the new data
    System.out.println(newData);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Applet");
    frame.setSize(400, 400);
    frame.add(new Applet());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class JSObject {
  // implementation of JSObject class
}