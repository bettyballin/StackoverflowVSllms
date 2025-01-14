import com.itextpdf.signatures.*;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CustomSignedPDF {
    public static final String DEST = "signed_custom_appearance.pdf";
    public static final String SRCPDF = "input.pdf";

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        PdfReader reader = new PdfReader(new FileInputStream(SRCPDF));
        PdfWriter writer = new PdfWriter(new FileOutputStream(DEST));
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        // Create a signature appearance
        PdfSignatureAppearance appearance = SignUtils.signDetached(pdfDoc, 
            null, null, null, null, null, -1, PdfSigner.CryptoStandard.CMS);

        // Create a custom form xobject for the signature appearance
        PdfFormXObject canvas = new PdfFormXObject(new Rectangle(0, 0, 200, 100));
        Canvas pdfCanvas = new Canvas(canvas, pdfDoc);
        // Add your graphic here
        // Example: pdfCanvas.add(new Image(ImageDataFactory.create("graphic.png")));

        appearance.setLayer2(canvas);

        // Adjust the size and position of the signature field as necessary
        appearance.setPageRect(new Rectangle(36, 500, 200, 100));
        pdfDoc.close();
    }
}

// Dummy SignUtils class to make the code executable
class SignUtils {
    public static PdfSignatureAppearance signDetached(
            PdfDocument pdfDoc, Object p1, Object p2, Object p3, Object p4, Object p5, int p6, PdfSigner.CryptoStandard p7)
            throws IOException, GeneralSecurityException {

        PdfSigner signer = new PdfSigner(pdfDoc.getReader(), pdfDoc.getWriter(), true);
        return signer.getSignatureAppearance();
    }
}