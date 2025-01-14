import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ConvertPDFtoImage {
    public static void main(String[] args) throws Exception {
        String command = "gs -dNOPAUSE -dBATCH -sDEVICE=png16m -r300 -sOutputFile=output.png input.pdf";
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        BufferedImage img = ImageIO.read(new File("output.png"));

        // Further processing if needed
    }
}