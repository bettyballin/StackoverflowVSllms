public class CreateShortcutActivity {

    public static void main(String[] args) {
        Intent shortcutIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com/"));
        shortcutIntent.setComponent(new ComponentName("com.isaacwaller.example", "com.isaacwaller.example.ExampleCut"));
    }
}

class Intent {
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    private String action;
    private Uri uri;
    private ComponentName component;

    public Intent(String action, Uri uri) {
        this.action = action;
        this.uri = uri;
    }

    public void setComponent(ComponentName component) {
        this.component = component;
    }
}

class Uri {
    private String uri;

    private Uri(String uri) {
        this.uri = uri;
    }

    public static Uri parse(String uriString) {
        return new Uri(uriString);
    }
}

class ComponentName {
    private String pkg;
    private String cls;

    public ComponentName(String pkg, String cls) {
        this.pkg = pkg;
        this.cls = cls;
    }
}