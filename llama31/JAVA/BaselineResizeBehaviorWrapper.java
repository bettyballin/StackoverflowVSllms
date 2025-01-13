import java.lang.reflect.Method;
import javax.swing.JComponent;
import javax.swing.plaf.Component;

public class BaselineResizeBehaviorWrapper {
    public static final int CONSTANT_ASCENT = 1;

    public static int getBaselineResizeBehavior(JComponent component) {
        try {
            // Try to call the Java6 method
            Method method = JComponent.class.getMethod("getBaselineResizeBehavior");
            Object result = method.invoke(component);
            if (result instanceof Component.BaselineResizeBehavior) {
                Component.BaselineResizeBehavior behavior = (Component.BaselineResizeBehavior) result;
                return behavior.ordinal() + 1; // Convert to a Java5-compatible int
            }
        } catch (NoSuchMethodException e) {
            // Java5 fallback: return a default value
            return CONSTANT_ASCENT;
        } catch (Exception e) {
            // Handle any other exceptions
            throw new RuntimeException(e);
        }
        return CONSTANT_ASCENT;
    }

    public static void main(String[] args) {
    }
}