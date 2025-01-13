/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageTranscoder {
    public static byte[] jpegToPng(String string) throws IOException {
        URL uRL = new URL(string);
        BufferedImage bufferedImage = ImageIO.read(uRL);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)bufferedImage, "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] stringArray) {
    }
}
