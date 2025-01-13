import java.lang.reflect.Method;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class JavaVersionAwareComponent extends JComponent {
    public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
        try {
            // Try to call the Java6 method
            Method method = JComponent.class.getMethod("getBaselineResizeBehavior");
            return (Component.BaselineResizeBehavior) method.invoke(this);
        } catch (NoSuchMethodException e) {
            // Java5 fallback: return a default value
            return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
        } catch (Exception e) {
            // Handle any other exceptions
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}