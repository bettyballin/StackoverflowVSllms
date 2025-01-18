import javafx.application.Application; 
import javafx.stage.Stage; 
import javax.management.*; 
import java.lang.management.*;
import java.beans.PropertyChangeSupport;

public class AlertPropertiesApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        alertProperties("java.version", System.getProperty("java.version"));
    }

    private static void alertProperties(String property, String currentValue)
            throws MalformedObjectNameException, NotCompliantMBeanException,
                   InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
       ManagementFactory.getPlatformMBeanServer().registerMBean(
        new PropertyChangeSupportWrapper(new PropertyChangeSupport(AlertPropertiesApp.class), property),
        new ObjectName("com.javaee:type=Properties"));
        alertPropertyNow(property, currentValue); 
    } 
    
    private static void alertPropertyNow(String property, String value) throws MalformedObjectNameException,
                                   InstanceNotFoundException, MBeanException, ReflectionException {
        ManagementFactory.getPlatformMBeanServer().invoke(
            new ObjectName("com.javaee:type=Properties"), "firePropertyChange",
            new Object[] { property, value },
            new String[] {"java.lang.String","java.lang.String"} );
    }
}

class PropertyChangeSupportWrapper implements DynamicMBean {

    private PropertyChangeSupport pcs;
    private String property;

    public PropertyChangeSupportWrapper(PropertyChangeSupport pcs, String property) {
        this.pcs = pcs;
        this.property = property;
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        // Implement as required
        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException,
            MBeanException, ReflectionException {
        // Implement as required
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        // Implement as required
        return null;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        // Implement as required
        return null;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException,
            ReflectionException {
        if ("firePropertyChange".equals(actionName) && params.length == 2 && signature.length == 2) {
            String prop = (String) params[0];
            String newVal = (String) params[1];
            pcs.firePropertyChange(prop, null, newVal);
            return null;
        }
        throw new ReflectionException(new NoSuchMethodException(actionName));
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanOperationInfo operation = new MBeanOperationInfo(
            "firePropertyChange",
            "Fires a property change event",
            new MBeanParameterInfo[] {
                new MBeanParameterInfo("property", "java.lang.String", "The property name"),
                new MBeanParameterInfo("value", "java.lang.String", "The new property value"),
            },
            "void",
            MBeanOperationInfo.ACTION
        );

        MBeanInfo info = new MBeanInfo(
            this.getClass().getName(),
            "PropertyChangeSupport Wrapper MBean",
            null, // attributes
            null, // constructors
            new MBeanOperationInfo[] { operation },
            null  // notifications
        );
        return info;
    }
}