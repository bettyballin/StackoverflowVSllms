import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class MyBean {
    private String property1;
    private String property2;

    // Getters and setters for properties
    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }
}

public class Main_252 {
    public static void main(String[] args) {
        MyBean bean = new MyBean();
        
        // Mocking request.getParameterMap() with a simple HashMap
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("property1", new String[]{"value1"});
        parameterMap.put("property2", new String[]{"value2"});

        try {
            BeanUtils.populate(bean, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Error populating bean: " + e.getMessage());
        }

        // Print the populated values to verify
        System.out.println(bean.getProperty1());
        System.out.println(bean.getProperty2());
    }
}