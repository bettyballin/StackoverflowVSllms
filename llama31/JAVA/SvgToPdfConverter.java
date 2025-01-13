import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PDFTranscoder;

public class SvgToPdfConverter {
    public static void main(String[] args) throws Exception {
        // Create a transcoder
        Transcoder transcoder = new PDFTranscoder();

        // Set the input and output files
        File inputFile = new File("input.svg");
        File outputFile = new File("output.pdf");

        // Create a transcoder input and output
        TranscoderInput input = new TranscoderInput(inputFile.toURI().toString());
        OutputStream outputStream = new FileOutputStream(outputFile);
        TranscoderOutput output = new TranscoderOutput(outputStream);

        // Perform the transcoding
        transcoder.transcode(input, output);

        // Close the output stream
        outputStream.close();
    }
}