import java.lang.String;
import java.util.ResourceBundle;

public class ViewPart {
    private static final String BUNDLE_NAME = "com.example.plugin.messages";
    
    private ResourceBundle resourceBundle; // Assume this is initialized

    public ViewPart() {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public String getViewName() {
        String viewNameKey = "%view.name"; // For illustration, normally just 'view.name'
        if (!viewNameKey.startsWith("%")) { // Assuming the '%' character is stripped before
            return viewNameKey;
        }
        try {
            viewNameKey = viewNameKey.substring(1); // Remove '%'
            return resourceBundle.getString(viewNameKey);
        } catch (Exception e) {
            // Handle missing key or similar errors
            return "Default View Name"; 
        }
    }

    // Other methods...

	public static void main(String[] args) {
	}
}