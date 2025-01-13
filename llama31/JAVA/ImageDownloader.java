import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImageDownloader {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://example.com/image.jpg").build();
        Response response = client.newCall(request).execute();

        BufferedImage image = ImageIO.read(response.body().byteStream());
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println(width + "x" + height);
    }
}