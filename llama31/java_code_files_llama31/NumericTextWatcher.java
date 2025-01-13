/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.widget.EditText
 *  android.widget.Toast
 */
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class NumericTextWatcher {
    private EditText editText;
    private Context context;

    public NumericTextWatcher(EditText editText, final Context context) {
        this.editText = editText;
        this.context = context;
        editText.addTextChangedListener(new TextWatcher(){

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                if (!charSequence.toString().matches("\\d+")) {
                    Toast.makeText((Context)context, (CharSequence)"Please use a numeric value", (int)0).show();
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public static void main(String[] stringArray) {
    }
}
