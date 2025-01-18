import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordVisibility {

    public static void main(String[] args) {
        // Initialize COM bridge for MS Word
        ActiveXComponent doc = new ActiveXComponent("Word.Application");

        // Given code:
        Variant visProp = Dispatch.get(doc, "Visible");  // read 'Visible' property
        System.out.println("Visible property before: " + visProp);

        Dispatch.put(doc, "Visible", Boolean.FALSE);    // set 'Visible' to false / hide MSWord

        // Check visibility after setting
        Variant visPropAfter = Dispatch.get(doc, "Visible");
        System.out.println("Visible property after: " + visPropAfter);

        // Quit Word application
        doc.invoke("Quit", new Variant[0]);

        // Clean up, release COM objects
        doc.safeRelease();
    }
}