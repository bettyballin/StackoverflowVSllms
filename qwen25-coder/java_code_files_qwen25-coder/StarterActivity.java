package com.example.yourserviceapp;

// Stub definitions for Android classes
class Bundle {
    // Empty class stub
}

class Intent {
    public Intent(Object obj, Class<?> cls) {
        // Empty constructor stub
    }
}

class Activity {
    protected void onCreate(Bundle savedInstanceState) {
        // Empty method stub
    }

    public void startService(Intent intent) {
        // Empty method stub
    }

    public void finish() {
        // Empty method stub
    }
}

class YourService {
    // Empty class stub
}

// Original code
public class StarterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the service
        Intent serviceIntent = new Intent(this, YourService.class);
        startService(serviceIntent);

        // Finish this activity immediately to avoid it being shown to the user
        finish();
    }

    public static void main(String[] args) {
        // Empty main method
    }
}