import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.DTD;

public class CustomTagHTMLDocument extends HTMLDocument {
    private static final String CUSTOM_TAG_NAME = "mytag";

    public CustomTagHTMLDocument() {
        super(new CustomDTD());
    }

    private static class CustomDTD extends DTD {
        public CustomDTD() {
            super("html32", // base DTD
                  "HTML", // name
                  "-//W3C//DTD HTML 4.01 Transitional//EN", // public ID
                  "http://www.w3.org/TR/html4/loose.dtd"); // system ID

            // Define the custom tag
            defineElement(CUSTOM_TAG_NAME, true, false);
            defineAttribute(CUSTOM_TAG_NAME, "id", "CDATA", "#IMPLIED", null);
        }
    }

    public static void main(String[] args) {
        // Create an instance of CustomTagHTMLDocument to test the custom DTD
        CustomTagHTMLDocument document = new CustomTagHTMLDocument();
        System.out.println("Custom HTML document created with custom DTD.");
    }
}