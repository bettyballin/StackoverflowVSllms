public class MyDialog extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_dialog, container);
    }
}

// Define stub classes for missing Android classes
class DialogFragment {
    public void show(FragmentTransaction ft, String tag) {
        // Stub method
    }
}

class View {
}

class LayoutInflater {
    public View inflate(Object resource, ViewGroup container) {
        return new View();
    }
}

class ViewGroup {
}

class Bundle {
}

class FragmentTransaction {
    public void setCustomAnimations(int enter, int exit) {
        // Stub method
    }
}

class R {
    public static class layout {
        public static Object my_dialog;
    }
}

class android {
    public static class animator {
        public static int fade_in;
        public static int fade_out;
    }
}

class FragmentManager {
    public FragmentTransaction beginTransaction() {
        return new FragmentTransaction();
    }
}

class Activity {
    public FragmentManager getSupportFragmentManager() {
        return new FragmentManager();
    }
}

// Main class with the activity code
public class MainActivity extends Activity {
    public static void main(String[] args) {
        MainActivity activity = new MainActivity();

        // And in your activity where you want to display the dialog:
        MyDialog myDiag = new MyDialog();
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.animator.fade_in, android.animator.fade_out);
        myDiag.show(ft, "MyDialog");
    }
}