import java.io.OutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;

public class ImageResponse {

    public void writeImageResponse(HttpServletResponse response, BufferedImage bufferedImage) throws IOException {
        response.setContentType("image/png"); // set response content type as png
        OutputStream os = response.getOutputStream();  // get an OutputStream object for writing the output to client (browser)
        ImageIO.write(bufferedImage, "PNG", os); // write image generated in step 1, written on this OS stream with PNG format.
        os.close(); // close outputstream once we are done
    }

}