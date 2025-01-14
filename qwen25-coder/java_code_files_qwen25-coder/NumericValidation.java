import java.lang.String;
import android.app.AlertDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class NumericValidation {

    public static void enableNumericValidation(Context context, EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().matches("[0-9]*")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Please use a numeric value.")
                           .setPositiveButton(android.R.string.ok, null)
                           .show();
                    // Optionally, clear the invalid input
                    editText.setText(s.toString().replaceAll("[^\\d]", ""));
                    // Place cursor at the end of the text field
                    editText.setSelection(editText.getText().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

	public static void main(String[] args) {
	}
}