import java.lang.String;

// Stub annotation
@interface NonNull {}

// Stub classes and interfaces to simulate Android classes
class DialogFragment {
    public void show(FragmentManager fm, String tag) {
        // Stub method
        System.out.println("DialogFragment show called with tag: " + tag);
    }

    public Activity getActivity() {
        return new Activity();
    }
}

class Dialog {
    // Stub class
}

class Bundle {
    // Stub class
}

class AlertDialog {
    public static class Builder {
        public Builder(Activity activity) {
            // Constructor stub
        }

        public Builder setIcon(int icon) {
            // Stub method
            return this;
        }

        public Builder setTitle(int title) {
            // Stub method
            return this;
        }

        public Builder setMessage(String message) {
            // Stub method
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            // Stub method
            return this;
        }

        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            // Stub method
            return this;
        }

        public Dialog create() {
            // Stub method
            return new Dialog();
        }
    }
}

class R {
    public static class drawable {
        public static final int smiley_happy = 1;
    }
    public static class string {
        public static final int dialog_success = 2;
        public static final int alert_dialog_newgame = 3;
        public static final int exit = 4;
    }
}

interface DialogInterface {
    interface OnClickListener {
        void onClick(DialogInterface dialog, int whichButton);
    }

    void dismiss();
}

class Activity {
    public void finish() {
        // Stub method
        System.out.println("Activity finish called");
    }

    public FragmentManager getSupportFragmentManager() {
        return new FragmentManager();
    }
}

class FragmentManager {
    // Stub class
}

// Main SuccessDialog class
public class SuccessDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String message = formatLevel() + formatMission();
        
        builder.setIcon(R.drawable.smiley_happy)
               .setTitle(R.string.dialog_success)
               .setMessage(message)
               .setPositiveButton(R.string.alert_dialog_newgame, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {
                       startANewGame(); // Ensure this method is accessible or use an interface/callback
                   }
               })
               .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {
                       getActivity().finish();
                   }
               });

        return builder.create();
    }

    private void startANewGame() {
        // Logic to start a new game
        System.out.println("Starting a new game...");
    }

    private String formatLevel() {
        // Replace with your logic
        return "Level: ";
    }

    private String formatMission() {
        // Replace with your logic
        return "Mission: ";
    }
}

// Usage in activity or fragment
class MainActivity extends Activity {
    public void someMethod() {
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.show(getSupportFragmentManager(), "success_dialog");
    }
    
    public static void main(String[] args) {
        MainActivity mainActivity = new MainActivity();
        mainActivity.someMethod();
    }
}