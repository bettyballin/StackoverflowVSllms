import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.text.TextPosition;

public class CustomPDFTextStripper {

    PDFTextStripper stripper = new PDFTextStripper() {
        @Override
        protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
            for (TextPosition pos : textPositions) {
                System.out.println("Word: " + pos.getUnicode() + ", Bounds: " + Arrays.toString(pos.getTextPositions())); // here you get the words along with their bounds in pixels
            }
        }
    };

    PDFTextStripperByArea stripperByArea;

    public CustomPDFTextStripper() throws IOException {
        stripper.setSortByPosition(true);
        stripperByArea = new PDFTextStripperByArea();
    }

    public static void main(String[] args) {
    }
}