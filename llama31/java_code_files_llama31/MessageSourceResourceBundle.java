/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.context.MessageSource
 */
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.context.MessageSource;

public class MessageSourceResourceBundle
extends ResourceBundle {
    private final MessageSource messageSource;

    public MessageSourceResourceBundle(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected Object handleGetObject(String string) {
        return this.messageSource.getMessage(string, null, Locale.getDefault());
    }

    @Override
    public Enumeration<String> getKeys() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] stringArray) {
    }
}
