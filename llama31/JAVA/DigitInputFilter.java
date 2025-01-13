import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class DigitInputFilter {
    public static void main(String[] args) {
        // Create an instance of EditText
        EditText editText = new EditText(null); // You would typically pass a Context here

        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i))) {
                        return "";
                    }
                }
                return null;
            }
        };

        editText.setFilters(new InputFilter[]{filter});
    }
}