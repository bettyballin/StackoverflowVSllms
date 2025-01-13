/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.widget.Toast
 */
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

class NumericTextWatcher.1
implements TextWatcher {
    final /* synthetic */ Context val$context;

    NumericTextWatcher.1() {
        this.val$context = context;
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        if (!charSequence.toString().matches("\\d+")) {
            Toast.makeText((Context)this.val$context, (CharSequence)"Please use a numeric value", (int)0).show();
        }
    }

    public void afterTextChanged(Editable editable) {
    }
}
