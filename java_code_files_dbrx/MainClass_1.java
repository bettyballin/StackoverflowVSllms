import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.Dialog;

public class MainClass {

    public static void main(String[] args) {
        WindowInterceptor windowInterceptor = new WindowInterceptor();
        windowInterceptor.process(new WindowHandler<MyDialog>() {
            @Override
            public Trigger process(final MyDialog dialog) {
                // Select the item causing an error
                final JComboBox combo = dialog.getCombo();
                new SwingEngine().exec(combo).selectItem("item causing error");

                WindowInterceptor interceptor = windowInterceptor.showWindow(new WindowMatcher<JDialog>() {
                    @Override
                    public boolean isMatching(final JDialog dialog) {
                        // Match the displayed window to be expected error message
                        return JOptionPaneMatcher.isErrorWithTitle(dialog, "Expected Error Message title");
                    }
                });

                interceptor.run();     // This will throw exception if error is not triggered as per your expectation (or customize this part)
                // ....
                return null; // Return appropriate Trigger
            }
        });
    }
}

class WindowInterceptor {
    public void process(WindowHandler<MyDialog> handler) {
        // Implement the method
        handler.process(new MyDialog());
    }

    public WindowInterceptor showWindow(WindowMatcher<JDialog> matcher) {
        // Implement the method
        return this;
    }

    public void run() {
        // Implement the method
    }
}

interface WindowHandler<T extends Dialog> {
    Trigger process(T dialog);
}

class MyDialog extends JDialog {
    public JComboBox getCombo() {
        return new JComboBox();
    }
}

interface Trigger {
    // methods
}

class SwingEngine {
    public SwingEngine exec(JComboBox combo) {
        // Do nothing
        return this;
    }

    public void selectItem(String item) {
        // Do nothing
    }
}

interface WindowMatcher<T extends Dialog> {
    boolean isMatching(T dialog);
}

class JOptionPaneMatcher {
    public static boolean isErrorWithTitle(Dialog dialog, String title) {
        // Do nothing, return true for compilation
        return true;
    }
}