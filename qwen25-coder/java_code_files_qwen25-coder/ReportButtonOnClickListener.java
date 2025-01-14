public class ReportButtonOnClickListener {

    public static void startActivity(Intent intent) {
        // Empty method placeholder
    }

    public static void main(String[] args) {
        // Create a button
        Button btnReport = new Button();

        // Set the click listener
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@example.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Issue Report");
                startActivity(emailIntent);
            }
        });
    }
}

class Button {
    public void setOnClickListener(View.OnClickListener listener) {
        // Simulate click event
        listener.onClick(null);
    }
}

class View {
    public interface OnClickListener {
        public void onClick(View v);
    }
}

class Intent {
    public static final int ACTION_SEND = 1;
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_SUBJECT = "EXTRA_SUBJECT";

    public Intent(int action) {
        // Constructor
    }

    public void setType(String type) {
        // Method stub
    }

    public void putExtra(String name, String value) {
        // Method stub
    }

    public void putExtra(String name, String[] values) {
        // Method stub
    }
}