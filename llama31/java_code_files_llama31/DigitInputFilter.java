/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 *  android.widget.EditText
 */
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class DigitInputFilter {
    public static void main(String[] stringArray) {
        EditText editText = new EditText(null);
        InputFilter inputFilter = new InputFilter(){

            public CharSequence filter(CharSequence charSequence, int n, int n2, Spanned spanned, int n3, int n4) {
                for (int i = n; i < n2; ++i) {
                    if (Character.isDigit(charSequence.charAt(i))) continue;
                    return "";
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[]{inputFilter});
    }
}
