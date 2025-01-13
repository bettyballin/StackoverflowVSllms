import java.util.ResourceBundle;

public class I18nHelper {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.mycompany.myapp.CustomObject");
        String message = bundle.getString("custom.object.message");
    }
}