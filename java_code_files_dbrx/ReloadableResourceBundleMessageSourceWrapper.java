import java.lang.String;

public class ReloadableResourceBundleMessageSourceWrapper {
    MessageSourceAdapter messageSource = new MessageSourceAdapter("path/to/resource-file");
    Locale locale;
    ResourceBundle bundle;

    {
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.afterPropertiesSet(); // This is required for the ReloadableResourceBundleMessageSource to initialize itself properly
        locale = LocaleContextHolder.getLocale();
        bundle = ResourceBundle.getBundle("messages", locale, messageSource);
    }

    public static void main(String[] args) {
    }
}