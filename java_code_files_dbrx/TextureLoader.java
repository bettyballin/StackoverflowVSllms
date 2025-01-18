import java.lang.String;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import com.jogamp.opengl.GL;

public class TextureLoader {
    public void initTextures(GL gl, String imageLocation) {
        try {
            // create a buffered-image object
            BufferedImage bufferedImage = ImageIO.read(new File(imageLocation));
            int[] pixelData = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
            Texture texture;

            // copy pixels from the image to an array and process it a bit more so that it's OpenGL readable
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int offset = y * bufferedImage.getWidth();

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    pixelData[offset + x] = bufferedImage.getRGB(x, y);
                }
            }

            // create a new texture object
            texture = new Texture();
            gl.glGenTextures(1, texture.getIdArray(), 0);

            // bind the texture to its target (in this case GL_TEXTURE_2D) and tell OpenGL what data type we are using for packing
            gl.glBindTexture(GL.GL_TEXTURE_2D, texture.get());
            gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
            gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA8, bufferedImage.getWidth(), bufferedImage.getHeight(), 0, GL.GL_RGB, GL.GL_UNSIGNED_BYTE, pixelData);
        } catch (IOException e) {
            // handle exception here; print a message on the console or something else depending upon your game/app design
        }
    }
    public static void main(String[] args) {
    }

    class Texture {
        private int[] id = new int[1];

        public int[] getIdArray() {
            return id;
        }

        public int get() {
            return id[0];
        }
    }
}