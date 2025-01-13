import javax.media.opengl.GL;
import javax.media.opengl.GLContext;

public class OpenGLChecker {
    public static void main(String[] args) {
        GL gl = GLContext.getCurrentGL();
        String extensions = gl.glGetString(GL.GL_EXTENSIONS);
    }
}