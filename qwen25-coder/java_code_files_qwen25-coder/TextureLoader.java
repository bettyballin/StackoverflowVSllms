import java.lang.String;
import javax.media.opengl.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

public class TextureLoader {
    public static int loadTexture(String path, GL2 gl) {
        try {
            BufferedImage img = ImageIO.read(TextureLoader.class.getResource(path));
            ByteBuffer buffer = ImageUtil.flipVertically(ImageUtil.loadByteBufferImage(img));

            int[] textureIds = new int[1];
            gl.glGenTextures(1, textureIds, 0);
            int id = textureIds[0];

            gl.glBindTexture(GL.GL_TEXTURE_2D, id);
            gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, img.getWidth(), img.getHeight(), 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buffer);

            // Setting filters and parameters
            gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
            gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);

            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Helper methods like ImageUtil.flipVertically and ImageUtil.loadByteBufferImage should be implemented to handle image processing.

    public static void main(String[] args) {
    }
}

class ImageUtil {
    public static ByteBuffer loadByteBufferImage(BufferedImage img) {
        // Dummy implementation
        return ByteBuffer.allocate(0);
    }

    public static ByteBuffer flipVertically(ByteBuffer buffer) {
        // Dummy implementation
        return buffer;
    }
}