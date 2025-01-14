public class NumericValidationActivity {

    EditText myEditText;

    {
        myEditText = findViewById(R.id.my_edit_text);
        NumericValidation.enableNumericValidation(this, myEditText);
    }

    public static void main(String[] args) {
    }

    public EditText findViewById(int id) {
        return new EditText();
    }
}

class EditText {
    // Empty class representing an EditText control
}

class R {
    public static class id {
        public static final int my_edit_text = 1;
    }
}

class NumericValidation {
    public static void enableNumericValidation(NumericValidationActivity activity, EditText editText) {
        // Method to enable numeric validation
    }
}