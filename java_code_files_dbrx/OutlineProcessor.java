import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfDictionary;

public class OutlineProcessor {
    private void processOutlineEntry(Object entryObj, PdfStamper stamper) {
        String name = null; // Name for destination to be specified if required. Otherwise NULL will do
        int pageNum = 0; // Desired Page number where the named destination will point to.
        Object[] items = SimpleBookmark.getBookmark(entryObj);
        PdfDestination dest;
        String title = (String) items[1];
        if (items[2] instanceof Number) { // This handles text bookmarks
            pageNum = ((Number) items[2]).intValue() - 1; // iText Pdf's are zero-indexed.
            dest = new PdfDestination(PdfDestination.FIT); // Define the type of destination to be used.
        } else if (items[2] instanceof String) { // This handles actions like /GoTo and other named destinations within the PDF itself.
            title = (String) items[3]; // As these type of outlines contain 4 items in their structure, we get our name from [3].
            pageNum = ((Number) ((PdfDictionary) (PdfAction) items[2]).get(PdfName.PAGE)).intValue() - 1;
            dest = new PdfDestination((PdfString) ((PdfDictionary) (PdfAction) items[2]).get(PdfName.DEST)); // Directly extract the destination and assign it to new one.
        } else {
            throw new ClassCastException("unrecognized outline structure");
        }
        stamper.addDestination(pageNum, dest, title); // Add Named Destinations to your existing PDF document with addDestination() method of PdfStamper instance.
    }

    public static void main(String[] args) {
    }
}