public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button recordStartButton = findViewById(R.id.record_start_button);
        recordStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecordStart();
            }
        });
    }

    private void onRecordStart() {
        // Your logic here, e.g., set geo location info
        setGeoLocationInfo();
    }

    private void setGeoLocationInfo() {
        // Example method to simulate setting geo location
    }

    public static void main(String[] args) {
        // Instantiate MainActivity and call onCreate
        MainActivity activity = new MainActivity();
        activity.onCreate(new Bundle());
    }
}

class AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
    }

    protected void setContentView(int layoutResID) {
    }

    protected <T> T findViewById(int id) {
        return (T)new Button();
    }
}

class Bundle {
}

class Button {
    public void setOnClickListener(View.OnClickListener listener) {
    }
}

class View {
    public interface OnClickListener {
        void onClick(View v);
    }
}

class R {
    public static class layout {
        public static final int activity_main = 0;
    }

    public static class id {
        public static final int record_start_button = 0;
    }
}