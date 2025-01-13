/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 */
import android.text.InputFilter;
import android.text.Spanned;

static class DigitInputFilter.1
implements InputFilter {
    DigitInputFilter.1() {
    }

    public CharSequence filter(CharSequence charSequence, int n, int n2, Spanned spanned, int n3, int n4) {
        for (int i = n; i < n2; ++i) {
            if (Character.isDigit(charSequence.charAt(i))) continue;
            return "";
        }
        return null;
    }
}
