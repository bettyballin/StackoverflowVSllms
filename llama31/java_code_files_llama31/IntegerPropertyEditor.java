/*
 * Decompiled with CFR 0.152.
 */
import java.beans.PropertyEditorSupport;
import java.text.NumberFormat;
import java.util.Locale;

public class IntegerPropertyEditor
extends PropertyEditorSupport {
    @Override
    public void setAsText(String string) throws IllegalArgumentException {
        try {
            NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
            numberFormat.setParseIntegerOnly(true);
            this.setValue(numberFormat.parse(string).intValue());
        }
        catch (Exception exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    @Override
    public String getAsText() {
        return this.getValue().toString();
    }

    public static void main(String[] stringArray) {
    }
}
