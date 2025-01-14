import java.lang.String;

public class ShortcutCreatorActivity {
    public ShortcutCreatorActivity() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            if (shortcutManager != null) {
                ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "unique_id")
                        .setShortLabel("ExampleCut")
                        .setLongLabel("Launch ExampleCut Activity")
                        .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_shortcut))
                        .setIntent(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.example.com"),
                                getApplicationContext(),
                                com.isaacwaller.example.ExampleCut.class))
                        .build();
                shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
            }
        } else {
            // Pre-O handling
            Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
            shortcutIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            shortcutIntent.setClassName(getApplicationContext(), com.isaacwaller.example.ExampleCut.class.getName());

            Intent addIntent = new Intent();
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "ExampleCut");
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                    Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.ic_shortcut));
            addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(addIntent);
        }
    }

    public static void main(String[] args) {
    }
}