import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.MessageSource;

public class MessageSourceResourceBundle extends ResourceBundle {

    private final MessageSource messageSource;

    public MessageSourceResourceBundle(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected Object handleGetObject(String key) {
        return messageSource.getMessage(key, null, Locale.getDefault());
    }

    @Override
    public Enumeration<String> getKeys() {
        // Not implemented, as it's not needed for Hibernate Validator
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
    }
}