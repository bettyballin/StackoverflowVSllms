import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GoogleStreetViewSwingBrowserorStreetViewBrowserAppcouldbesuitablenamesforthisclassgiventhatitappearstodisplayaGooglestreetviewwithinaJavaSwingbrowser {
    public static void main(String[] args) {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        shell.setText("Tentative API Google avec un SWT.Browser");
        shell.setLayout(new GridLayout());
        final Browser browser = new Browser(shell, SWT.BORDER);
        browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        browser.setText("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml\">"
                + "<head>"
                + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>"
                + "<script src=\"https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&v=weekly\"></script>"
                + "<title>Google Maps JavaScript API Example: Simple Streetview Example</title>"
                + "<script type=\"text/javascript\">var myPano;"
                + "function initMap(){"
                + "var fenwayPark = {lat: 42.345573, lng: -71.098326};"
                + "var panoramaOptions = { position: fenwayPark };"
                + "myPano = new google.maps.StreetViewPanorama(document.getElementById(\"pano\"), panoramaOptions);}"
                + "</script></head>"
                + "<body onload=\"initMap()\">"
                + "<div id=\"pano\" style=\"width: 500px; height: 300px;\"></div>"
                + "</body></html>");
        shell.open();
    
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}