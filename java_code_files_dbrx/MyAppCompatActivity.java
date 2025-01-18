public class MyAppCompatActivity extends AppCompatActivity {
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null && "myapp".equalsIgnoreCase(uri.getScheme())) {
            // Process OAuth response here based on the given URI data.
        }
    }
    public static void main(String[] args) {
    }
}

class AppCompatActivity {
    protected void onNewIntent(Intent intent) {
        // Base implementation
    }
}

class Intent {
    public Uri getData() {
        // Return a new Uri instance
        return new Uri();
    }
}

class Uri {
    public String getScheme() {
        // Return a dummy scheme
        return "myapp";
    }
}