import java.io.File;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.swing.*;
import java.awt.*;

public class TextureLoader implements GLEventListener {
    private Texture texture;

    public TextureLoader() {
        try {
            texture = TextureIO.newTexture(new File("path/to/texture.png"), false);
        } catch (Exception e) {
            System.err.println("Error loading texture: " + e.getMessage());
        }
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL.GL_TEXTURE_2D);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        texture.bind(gl);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    public static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);

        TextureLoader loader = new TextureLoader();
        canvas.addGLEventListener(loader);

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();

        JFrame frame = new JFrame("Texture Loader");
        frame.getContentPane().add(canvas);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}