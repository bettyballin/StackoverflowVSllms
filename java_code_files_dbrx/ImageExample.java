import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class ImageExample {
    public static void main(String[] args) {
        byte[] byteArray = null; // Your raw Image data here
        int width = 100; // Width of the image
        int height = 100; // Height of the image
        boolean hasAlphaChannel = false; // Set to true if your image has an alpha channel, otherwise false
        BufferedImage bufferedImage = new BufferedImage(width, height,
                hasAlphaChannel ? BufferedImage.TYPE_4BYTE_ABGR : BufferedImage.TYPE_3BYTE_BGR);
        DataBufferByte buffer = (DataBufferByte) bufferedImage.getRaster().getDataBuffer();
        byte[] imageData = byteArray != null ? byteArray : new byte[width * height * (hasAlphaChannel ? 4 : 3)]; // Assume RGB or RGBA, scale if necessary
        // Copy imageData into the buffer
        byte[] bufferData = buffer.getData();
        System.arraycopy(imageData, 0, bufferData, 0, imageData.length);
    }
}