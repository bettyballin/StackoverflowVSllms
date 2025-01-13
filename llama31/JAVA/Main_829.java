import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyAccessor;
import org.apache.commons.beanutils.PropertyUtils;

// Define the Thing class
class Thing {
    private String thingName;

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }
}

// Define the MyForm class
class MyForm {
    private String name;
    private int id;
    private Thing thing;

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }
}

// Define the MyBeanUtilsBean class
class MyBeanUtilsBean extends BeanUtilsBean {
    public MyBeanUtilsBean() {
        super(new MyPropertyAccessor());
    }
}

// Define the MyPropertyAccessor class
class MyPropertyAccessor implements PropertyAccessor {
    @Override
    public Object getProperty(Object bean, String name) throws IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        // Handle nested properties
        if (name.contains(".")) {
            String[] parts = name.split("\\.");
            Object currentBean = bean;
            for (int i = 0; i < parts.length - 1; i++) {
                currentBean = PropertyUtils.getProperty(currentBean, parts[i]);
            }
            return PropertyUtils.getProperty(currentBean, parts[parts.length - 1]);
        } else {
            return PropertyUtils.getProperty(bean, name);
        }
    }

    @Override
    public void setProperty(Object bean, String name, Object value) throws IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        // Handle nested properties
        if (name.contains(".")) {
            String[] parts = name.split("\\.");
            Object currentBean = bean;
            for (int i = 0; i < parts.length - 1; i++) {
                currentBean = PropertyUtils.getProperty(currentBean, parts[i]);
            }
            PropertyUtils.setProperty(currentBean, parts[parts.length - 1], value);
        } else {
            PropertyUtils.setProperty(bean, name, value);
        }
    }
}

public class Main_829 {
    public static void main(String[] args) {
        // Create a new MyForm object
        MyForm myForm = new MyForm();

        // Create a new Thing object
        Thing thing = new Thing();
        thing.setThingName("My Thing");

        // Set the Thing object on the MyForm object
        myForm.setThing(thing);

        // Create a new MyBeanUtilsBean object
        MyBeanUtilsBean beanUtilsBean = new MyBeanUtilsBean();

        // Use the MyBeanUtilsBean object to get the Thing object from the MyForm object
        try {
            Object value = beanUtilsBean.getPropertyUtils().getProperty(myForm, "thing.thingName");
            System.out.println(value); // prints: My Thing
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}