import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class MyClientBundle {
    // Create a ClientBundle interface
    public interface MyClientBundle extends ClientBundle {
        @Source("page1.html")
        TextResource page1Html();

        @Source("page2.html")
        TextResource page2Html();

        // ...
    }

    // In your GWT module, create an instance of the ClientBundle
    public static void main(String[] args) {
        MyClientBundle bundle = GWT.create(MyClientBundle.class);

        // To use the HTML content in a widget
        // Note: This will not work in a standard Java environment, 
        // as HTML is a GWT widget and requires a GWT environment.
        // HTML htmlWidget = new HTML(bundle.page1Html().getText());
    }
}