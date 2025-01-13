import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSheetPageBreak;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class SpreadsheetDocumentPaginator {
    public int getPageCount() {
        XComponent xComponent = getDocument();
        XSpreadsheetDocument xSpreadsheetDocument = (XSpreadsheetDocument) UnoRuntime.queryInterface(
                XSpreadsheetDocument.class, xComponent);

        XSpreadsheets xSpreadsheets = xSpreadsheetDocument.getSheets();
        int pageCount = 0;

        for (int i = 0; i < xSpreadsheets.getCount(); i++) {
            XSpreadsheet xSpreadsheet = (XSpreadsheet) UnoRuntime.queryInterface(
                    XSpreadsheet.class, xSpreadsheets.getByIndex(i));

            XSheetPageBreak xSheetPageBreak = (XSheetPageBreak) UnoRuntime.queryInterface(
                    XSheetPageBreak.class, xSpreadsheet);

            if (xSheetPageBreak != null) {
                int pageBreakCount = xSheetPageBreak.getPageBreaks().getCount();
                pageCount += pageBreakCount + 1; // add 1 for the last page
            } else {
                pageCount++; // if there are no page breaks, there is still one page
            }
        }

        return pageCount;
    }

    public XComponent getDocument() {
        XComponentContext context = com.sun.star.comp.helper.Bootstrap.bootstrap();

        XMultiComponentFactory factory = context.getServiceManager();

        Object desktop = factory.createInstanceWithContext(
                "com.sun.star.frame.Desktop", context);

        XComponentLoader loader = (XComponentLoader) UnoRuntime.queryInterface(
                XComponentLoader.class, desktop);

        XComponent component = loader.loadComponentFromURL("file:///path/to/file.ods",
                "_blank", 0, new com.sun.star.beans.PropertyValue[0]);

        return UnoRuntime.queryInterface(XComponent.class, component);
    }

    public static void main(String[] args) {
        SpreadsheetDocumentPaginator paginator = new SpreadsheetDocumentPaginator();
        int pageCount = paginator.getPageCount();
        System.out.println("Page count: " + pageCount);
    }
}