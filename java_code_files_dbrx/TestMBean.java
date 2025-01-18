import javax.management.*;

public class TestMBean implements DynamicMBean {
    public int state;
    // other instance variables...

    @Override
    public Object getAttribute(String name) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (name == null || !name.equals("State")) {
            throw new AttributeNotFoundException();
        }
        return state;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null || !attribute.getName().equals("State")) {
            throw new AttributeNotFoundException();
        }
        Object value = attribute.getValue();
        if (!(value instanceof Integer)) {
            throw new InvalidAttributeValueException();
        }
        state = (Integer) value;
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        AttributeList list = new AttributeList();
        if (attributes == null) return list;
        for (String name : attributes) {
            if (name.equals("State")) {
                list.add(new Attribute("State", state));
            }
        }
        return list;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        AttributeList list = new AttributeList();
        if (attributes == null) return list;
        for (Object obj : attributes) {
            Attribute attr = (Attribute) obj;
            try {
                setAttribute(attr);
                list.add(new Attribute(attr.getName(), attr.getValue()));
            } catch (Exception e) {
                // Ignore exceptions and continue
            }
        }
        return list;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        // No operations are implemented
        throw new ReflectionException(new NoSuchMethodException(actionName));
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo attrInfo = new MBeanAttributeInfo(
                "State", "int", "State attribute", true, true, false);
        MBeanInfo info = new MBeanInfo(
                this.getClass().getName(),
                "Test MBean",
                new MBeanAttributeInfo[]{attrInfo},
                null, // constructors
                null, // operations
                null  // notifications
        );
        return info;
    }
}