import java.lang.String;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Toast;
import android.content.Context;

public class NumericTextWatcher {
    private EditText editText;
    private Context context;

    public NumericTextWatcher(EditText editText, Context context) {
        this.editText = editText;
        this.context = context;

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().matches("\\d+")) {
                    Toast.makeText(context, "Please use a numeric value", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public static void main(String[] args) {}
}