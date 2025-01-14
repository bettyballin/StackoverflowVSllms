public class MyOAuthCallbackActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        
        // Check if there is data in the intent
        Intent intent = getIntent();

        Uri uri = intent.getData();
        if (uri != null && uri.getScheme().equals("myapp")) {
            // Handle OAuth callback here
            String verifier = uri.getQueryParameter("oauth_verifier");
            String token = uri.getQueryParameter("oauth_token");

            // Use the verifier and token to complete the OAuth process
        }
    }

    public static void main(String[] args) {
    }
}

// Placeholder definitions for Activity, Intent, Uri

class Activity {
    protected void onResume() { }
    protected Intent getIntent() { return new Intent(); }
}

class Intent {
    public Uri getData() { return new Uri(); }
}

class Uri {
    public String getScheme() { return ""; }
    public String getQueryParameter(String key) { return ""; }
}