import java.io.*;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.SVGConverter;

public class EpsToPng {
    public static void main(String[] args) throws Exception {
        Transcoder transcoder = new PNGTranscoder();
        String inputFile = "input_eps_file.eps";
        FileInputStream epsStream = null;

        try {
            epsStream = new FileInputStream(new File(inputFile));

            // Set the transcoding hints used to transcode the EPS file.
            transcoder.addTranscodingHint(SVGConverter.KEY_IN_CONTENT_HANDLER, "org.apache.fop.svg.SAXHandler");
            transcoder.addTranscodingHint(PNGTranscoder.KEY_BACKGROUND_COLOR, java.awt.Color.WHITE); // optional: sets the background color to white

            // Create a new transcoder input from the EPS file
            TranscoderInput epsInput = new TranscoderInput(epsStream);
            FileOutputStream outputFile = null;

            try {
                String imageFileName = "./" + "image_output_name.png";
                outputFile = new FileOutputStream(new File(imageFileName));

                // Create the transcoder output for the PNG file
                TranscoderOutput pngOutput = new TranscoderOutput(new OutputStreamWriter(outputFile, "UTF-8"));

                // Convert and write the EPS into a PNG image.
                transcoder.transcode(epsInput, pngOutput);
            } finally {
                if (null != outputFile) {
                    try {
                        outputFile.flush();
                        System.out.println("Flushed.");
                        outputFile.close();
                    } catch (IOException e2) {
                        System.err.println("Failed to write image file:" + e2);
                    }
                }
            }
        } finally {
            if (null != epsStream) {
                epsStream.close();
            }
        }
    }
}