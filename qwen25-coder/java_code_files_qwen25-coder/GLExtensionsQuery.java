import javax.media.opengl.*;
import java.nio.IntBuffer;

public class GLExtensionsQuery implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        GL3 gl = drawable.getGL().getGL3();

        String extString = gl.glGetString(GL.GL_EXTENSIONS);
        if (extString != null) {
            System.out.println("Supported extensions:");
            for (String ext : extString.split("\\s")) {
                System.out.print(ext + ", ");
            }
        } else {
            IntBuffer params = IntBuffer.allocate(1);
            gl.glGetIntegerv(GL3.GL_NUM_EXTENSIONS, params);
            int nExtensions = params.get(0);
            System.out.println("Supported extensions:");
            for (int i = 0; i < nExtensions; i++) {
                String ext = gl.glGetStringi(GL3.GL_EXTENSIONS, i);
                System.out.print(ext + ", ");
            }
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) { }

    @Override
    public void init(GLAutoDrawable drawable) { }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) { }

    public static void main(String[] args) {
        // Set up an OpenGL context and window to run the GLEventListener
        // This is necessary to actually execute the display method
        GLProfile profile = GLProfile.get(GLProfile.GL3);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);

        canvas.addGLEventListener(new GLExtensionsQuery());

        final javax.swing.JFrame frame = new javax.swing.JFrame("GLExtensionsQuery");
        frame.getContentPane().add(canvas);
        frame.setSize(800, 600);
        frame.setVisible(true);

        // Animator to continuously repaint the canvas
        com.jogamp.opengl.util.Animator animator = new com.jogamp.opengl.util.Animator(canvas);
        animator.start();
    }
}