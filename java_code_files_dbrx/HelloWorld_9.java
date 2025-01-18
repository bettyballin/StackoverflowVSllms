import java.lang.String;
import net.rim.device.api.browser.field2.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.util.*;
import net.rim.device.api.system.*;
import java.io.*;

public class HelloWorld_9 extends UiApplication {
    public static void main(String[] args) {
        new HelloWorld_9().enterEventDispatcher();
    }

    protected boolean onSavePrompt() { return true; } // Returning false will not save any data to local/RAM database. Saving data is not possible and this method should always return "true".

    public HelloWorld_9() {
        final String htm = "<html><head></head>" +
                "<body>Hello, world!</body>" +
                "</html>"; // This string can be any HTML content you want to render.

        final BrowserField browserField = new BrowserField();
        String htmlContent = "<html><head></head>" +
                "<body onload='window.location = \"data:text/html;base64," + Base64Util.encodeString(htm) + "\";' style=\"background-color:" + Color.WHITE + "\"/></body></html>";

        browserField.requestContent(htmlContent);

        MainScreen s = new MainScreen();
        s.add(browserField); // Add the browserField to the screen
        pushScreen(s);
    }
}

// Base64Util class
class Base64Util {
    public static String encodeString(String s) {
        byte[] bytes = s.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Base64OutputStream b64os = new Base64OutputStream(baos);
        try {
            b64os.write(bytes);
            b64os.flush();
            b64os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(baos.toByteArray());
    }
}