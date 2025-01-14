import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import com.itextpdf.io.image.ImageDataFactory;

import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class SvgToPdf {
    public static void main(String[] args) throws IOException {
        String svgURI = "path_to_your_logo.svg";

        // Transcode SVG to PNG first
        ByteArrayOutputStream pngOs = new ByteArrayOutputStream();
        PNGTranscoder t = new PNGTranscoder();
        TranscoderInput input = new TranscoderInput(svgURI);
        TranscoderOutput output = new TranscoderOutput(pngOs);
        try {
            t.transcode(input, output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayInputStream in = new ByteArrayInputStream(pngOs.toByteArray());
        File file = new File("output.pdf");

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        Rectangle2D.Float rect = new Rectangle2D.Float(0, 0, 100, 100);
        Image img = new Image(ImageDataFactory.create(pngOs.toByteArray()));
        img.scaleToFit((float) rect.getWidth(), (float) rect.getHeight());
        document.add(img);

        document.close();
    }
}