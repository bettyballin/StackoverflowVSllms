import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;

public class JPegReadTest {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            File srcFile = new File(args[0]);
            File destFile = new File(args[1]);

            ImageReader reader = ImageIO.getImageReadersByFormatName("jpg").next();
            ImageReadParam param = reader.getDefaultReadParam();
            param.setDestinationType(BufferedImage.TYPE_INT_RGB);

            try (FileImageInputStream fis = new FileImageInputStream(srcFile)) {
                reader.setInput(fis);
                BufferedImage src = reader.read(0, param);

                ImageIO.write(src, "jpg", destFile);
            }
        } else {
            System.err.println("Usage: java JPegReadTest src dest");
        }
    }
}