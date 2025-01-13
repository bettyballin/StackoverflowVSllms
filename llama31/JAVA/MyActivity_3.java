import java.util.EventListener;

// Define an interface for a record start listener
interface RecordStartListener extends EventListener {
    void onRecordStart();
}

// Simulate an AppCompatActivity by renaming it to a standard Java class
class MyActivity {
    // Implement the RecordStartListener interface
    private class RecordStartListenerImpl implements RecordStartListener {
        @Override
        public void onRecordStart() {
            // Perform actions when record starts
            System.out.println("Record started.");
        }
    }

    // Simulate setting a button click listener
    public void setButtonClickListener() {
        // Create a new instance of RecordStartListenerImpl
        RecordStartListenerImpl listener = new RecordStartListenerImpl();
        // Simulate a button click
        listener.onRecordStart();
    }

    public static void main(String[] args) {
        MyActivity activity = new MyActivity();
        activity.setButtonClickListener();
    }
}