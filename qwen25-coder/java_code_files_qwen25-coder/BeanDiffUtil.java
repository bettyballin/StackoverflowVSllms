import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanDiffUtil {

    public static Map<String, Object[]> diffBeans(Object bean1, Object bean2) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        if (bean1 == null || bean2 == null || !bean1.getClass().equals(bean2.getClass())) {
            throw new IllegalArgumentException("Invalid beans for comparison");
        }

        Map<String, Object[]> diffs = new HashMap<>();
        PropertyDescriptor[] descriptors = getPropertyDescriptors(bean1);

        for (PropertyDescriptor descriptor : descriptors) {
            if ("class".equals(descriptor.getName())) continue;

            Object prop1 = descriptor.getReadMethod().invoke(bean1);
            Object prop2 = descriptor.getReadMethod().invoke(bean2);

            if ((prop1 == null && prop2 != null) || (prop1 != null && !prop1.equals(prop2))) {
                diffs.put(descriptor.getName(), new Object[]{prop1, prop2});
            }
        }

        return diffs;
    }

    private static PropertyDescriptor[] getPropertyDescriptors(Object bean) throws IntrospectionException {
        java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean.getClass());
        return info.getPropertyDescriptors();
    }

    public static void main(String[] args) {
        // Example usage
        try {
            MyBean bean1 = new MyBean("John", 30);
            MyBean bean2 = new MyBean("Jane", 32);

            Map<String, Object[]> diffs = diffBeans(bean1, bean2);

            for (Map.Entry<String, Object[]> entry : diffs.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue()[0] + " -> " + entry.getValue()[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyBean {
    private String name;
    private int age;

    public MyBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}