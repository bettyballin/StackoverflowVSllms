import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.util.resource.locator.ClasspathResourceStreamLocator;

public class MyApplication_4_4 extends WebApplication {
    @Override
    protected void init() {
        super.init();
        getResourceSettings().setResourceStreamLocator(new ClasspathResourceStreamLocator());
    }

    public static void main(String[] args) {
    }
}