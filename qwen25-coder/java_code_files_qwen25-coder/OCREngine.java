import java.lang.String;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract; // JNA wrapper Import
import net.sourceforge.tess4j.Tesseract1; // JNI wrapper Import

import java.io.File;

public class OCREngine {
    public static String doOCR(String filePath) throws Exception {
        ITesseract instance = new Tesseract();  // JNA Interface
        /** Do OCR on the image */
        return instance.doOCR(new File(filePath));
    }

    public static void main(String[] args) {
    }
}