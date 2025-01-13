import java.lang.String;
import java.beans.PropertyEditorSupport;
import java.text.NumberFormat;
import java.util.Locale;

public class IntegerPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            NumberFormat format = NumberFormat.getIntegerInstance(Locale.getDefault());
            format.setParseIntegerOnly(true);
            setValue(format.parse(text).intValue());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }

	public static void main(String[] args) {
	}
}