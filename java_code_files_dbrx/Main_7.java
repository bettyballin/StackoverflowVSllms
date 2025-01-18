import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main_7 {
  public static void main(String[] args) {
    try {
      Display.setDisplayMode(new DisplayMode(800,600));
      Display.create();
    } catch (LWJGLException e) {
      System.err.println("ERROR: " + e);
    }

    // OpenGL code here...
  }
}