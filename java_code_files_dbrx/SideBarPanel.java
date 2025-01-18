import com.sun.star.uno.XComponentContext;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.lang.XInitialization;
import com.sun.star.lang.XMultiServiceFactory;
import com.sun.star.beans.PropertyValue;
import com.sun.star.awt.XWindow;
import com.sun.star.frame.XFrame;
import com.sun.star.beans.XPropertySet;
import com.sun.star.awt.UnoControlContainerWindowType;

public class SideBarPanel implements XInitialization {
    private XComponentContext context;
    // any additional fields you may need...

    @Override
    public void initialize(Object[] args) throws Exception {
        this.context = (XComponentContext) args[0];
        try {
            createSidebarPanel();
        } catch (Exception e) {
            System.err.println("Error creating sidebar panel: " + e);
        }
    }

    private void createSidebarPanel() throws Exception {
        // Create XFrame for your UI and set its window type as SIDEBAR_TYPE
        PropertyValue[] pv = new PropertyValue[0];   // initialize with default values
        XMultiServiceFactory mg = (XMultiServiceFactory) UnoRuntime.queryInterface(XMultiServiceFactory.class, context);
        XWindow wndw = null; // your window from where you want to open sidebar panel
        if (wndw != null) {
            Object sbFrame = mg.createInstanceWithContext("com.sun.star.awt.Toolkit", context);
            XFrame aNewSideBarFrame = (XFrame) UnoRuntime.queryInterface(XFrame.class, sbFrame);
            ((XPropertySet) aNewSideBarFrame).setPropertyValue("WindowType",
                    new Short((short) (UnoControlContainerWindowType.SIDEBAR_TYPE)));
        } else {
            throw new Exception("Null window is not allowed.");
            // Do something
        }
    }

    public static void main(String[] args) {
    }
}