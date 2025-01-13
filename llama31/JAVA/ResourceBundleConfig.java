import java.lang.String;

public class ResourceBundleConfig {
    public ResourceBundle resourceBundle(MessageSource messageSource) {
        return new MessageSourceResourceBundle(messageSource);
    }

    public static void main(String[] args) {
    }
}