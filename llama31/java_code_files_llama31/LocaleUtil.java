/*
 * Decompiled with CFR 0.152.
 */
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class LocaleUtil {
    Locale locale = Locale.getDefault();
    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(this.locale);
    char listSeparator = this.dfs.getGroupingSeparator();

    public static void main(String[] stringArray) {
    }
}
