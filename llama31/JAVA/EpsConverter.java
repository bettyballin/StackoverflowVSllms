import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class EpsConverter {
    public static void main(String[] args) throws Exception {
        // Input EPS file
        File epsFile = new File("input.eps");

        // Output PNG file
        File pngFile = new File("output.png");

        // Create a transcoder
        Transcoder transcoder = new PNGTranscoder();

        // Set the input and output files
        TranscoderInput input = new TranscoderInput(new FileInputStream(epsFile));
        TranscoderOutput output = new TranscoderOutput(new FileOutputStream(pngFile));

        // Transcode the EPS file to PNG
        transcoder.transcode(input, output);
    }
}