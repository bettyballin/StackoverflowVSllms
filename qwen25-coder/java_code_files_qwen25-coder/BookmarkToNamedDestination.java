import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.action.PdfGoToRemote;
import com.itextpdf.kernel.pdf.action.PdfJavaScript;
import com.itextpdf.kernel.pdf.canvas.destination.PdfDestination;
import com.itextpdf.kernel.pdf.canvas.destination.PdfExplicitDestination;
import com.itextpdf.kernel.pdf.navigation.PdfOutline;
import com.itextpdf.layout.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookmarkToNamedDestination {
    public static final String SRC = "path/to/input.pdf";
    public static final String DEST = "path/to/output.pdf";

    private static final Logger logger = LoggerFactory.getLogger(BookmarkToNamedDestination.class);

    public static void main(String[] args) throws Exception {
        PdfReader reader = new PdfReader(SRC);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        // Create a document to help with layout in case needed.
        Document doc = new Document(pdfDoc);

        createNamedDestinationsFromBookmarks(pdfDoc.getOutlines(false), pdfDoc, doc);

        reader.close();
        writer.close();
    }

    private static void createNamedDestinationsFromBookmarks(PdfOutline parent,
                                                             PdfDocument pdfDoc,
                                                             Document doc) {
        for (PdfOutline child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
            PdfAction action = child.getAction();
            if (action instanceof PdfGoToRemote
                || action instanceof PdfJavaScript) {
                logger.warn("Unsupported action type for this example.");
                continue;
            }

            String title = child.getTitle();

            // Assuming the action is a PdfGoTo and it has a destination
            if (action != null && action.getDestination() != null) {
                PdfDestination pdfDestination = action.getDestination();
                pdfDoc.addNamedDestination(title, pdfDestination);

                logger.info("Created named destination: " + title);
            } else {
                // If no action is associated with the bookmark, create a named destination pointing to the start of its page
                // Get the page number from the outline's destination
                int pageNumber = 1; // default to page 1
                PdfDestination dest = child.getDestination();
                if (dest != null) {
                    pageNumber = pdfDoc.getPageNumber(dest.getPage(pdfDoc));
                }

                PdfDestination newDestination = PdfExplicitDestination.createFit(pdfDoc.getPage(pageNumber));
                pdfDoc.addNamedDestination(title, newDestination);
                logger.info("Created named destination for " + title + " at page " + pageNumber);
            }

            if (child.hasChildren()) {
                createNamedDestinationsFromBookmarks(child, pdfDoc, doc);
            }
        }
    }
}