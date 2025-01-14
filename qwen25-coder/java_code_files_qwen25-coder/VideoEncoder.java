import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import org.jcodec.api.awt.SequenceEncoder;

public class VideoEncoder {
    SequenceEncoder encoder;

    public void prepare(String filename) throws IOException {
        encoder = new SequenceEncoder(new File(filename));
    }

    public void encode(BufferedImage image) throws IOException {
        encoder.encodeImage(image);
    }

    public void finish() throws IOException {
        encoder.finish();
    }

    public static void main(String[] args) {
    }
}