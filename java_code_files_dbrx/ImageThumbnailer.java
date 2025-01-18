import java.lang.String;
import java.awt.*;
import javax.media.jai.*;
import com.sun.media.jai.codec.*;
import java.io.FileOutputStream;

public class ImageThumbnailer {
  public static void createThumbnail(String input, String output) throws Exception {
    FileSeekableStream stream = new FileSeekableStream(input);
    ImageDecoder decoder = ImageCodec.createImageDecoder("jpeg", stream, null);

    ParameterBlock pb = new ParameterBlock();
    pb.addSource(decoder.decodeAsRenderedImage());
    int thumbnailWidth = 150;
    double scalePercentage = (double)thumbnailWidth / decoder.getWidth(0);
    pb.add((float)scalePercentage);         // X scale factor
    pb.add((float)scalePercentage);         // Y scale factor
    pb.add(0.0F);                   // X translation
    pb.add(0.0F);                   // Y translation
    RenderedOp rescaled = JAI.create("scale", pb);
    FileOutputStream fos = new FileOutputStream(output);
    ImageEncoder encoder = ImageCodec.createImageEncoder("jpeg", fos, null);
    encoder.encode(rescaled);
  }

  public static void main(String[] args) {
  }
}