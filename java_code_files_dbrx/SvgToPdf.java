import java.io.FileOutputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.PDFTranscoder;
import org.apache.batik.transcoder.TranscoderOutput;

public class SvgToPdf {
    public static void main(String[] args) throws Exception {
        String svgFilename = "path_to_your\\file.svg"; // Change this to the path of your SVG file
        String pdfFilename = "path_to_your\\file.pdf";  // Change this to where you want to save the PDF

        TranscoderInput input = new TranscoderInput(svgFilename);
        TranscoderOutput output = new TranscoderOutput(new FileOutputStream(pdfFilename));

        PDFTranscoder transcoder = new PDFTranscoder();
        transcoder.addTranscodingHint(SVGAbstractTranscoder.KEY_WIDTH, new Float(12.0f)); // Set the width
        transcoder.addTranscodingHint(SVGAbstractTranscoder.KEY_HEIGHT, new Float(8.5f)); // Set the height

        transcoder.transcode(input, output);
    }
}