import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public class MainClass {

    public interface OurResources extends ClientBundle {
        @Source("ourhtml.html")
        TextResource ourHtml();
    }

    // Use in your application
    OurResources resources = GWT.create(OurResources.class);
    HTML htmlContainer = new HTML(resources.ourHtml().getText());

    public static void main(String[] args) {
    }
}