import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class Main_340 {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("path/to/tessdata");
        tesseract.setLanguage("eng");
        File imageFile = new File("path/to/image.jpg"); // specify your image file
        try {
            String text = tesseract.doOCR(imageFile);
            System.out.println(text);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}