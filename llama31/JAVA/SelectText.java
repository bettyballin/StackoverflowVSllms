import java.lang.String;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.text.XTextDocument;
import com.sun.star.text.XTextSelection;

public class SelectText {
    public static void main(String[] args) {
        // Get the current document
        XTextDocument doc = (XTextDocument) UnoRuntime.queryInterface(
            XTextDocument.class, 
            new com.sun.star.beans.PropertyValue("Hidden", false)
        );

        // Get the first paragraph
        XTextSelection selection = (XTextSelection) UnoRuntime.queryInterface(
            XTextSelection.class, 
            doc.getText().createTextCursor().gotoStartOfParagraph(true)
        );

        // Select the first 10 characters
        selection.gotoStartOfParagraph(true);
        selection.gotoOffset(10, true);
    }
}