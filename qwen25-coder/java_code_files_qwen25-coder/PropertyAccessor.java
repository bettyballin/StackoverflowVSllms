import java.lang.String;
import java.util.function.Function;

public class PropertyAccessor {
    static YourObject2Type Object1 = new YourObject2Type();

    static String value = safeGetProperty(Object1,
                                          o -> ((YourObject2Type) o).getObject2(),
                                          o -> ((YourObject3Type) o).getObject3(),
                                          o -> ((YourPropertyType) o).getProperty());

    public static void main(String[] args) {
        System.out.println(value);
    }

    static String safeGetProperty(Object obj,
                                  Function<Object, Object> f1,
                                  Function<Object, Object> f2,
                                  Function<Object, String> f3) {
        try {
            Object result1 = f1.apply(obj);
            Object result2 = f2.apply(result1);
            String result = f3.apply(result2);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}

class YourObject2Type {
    public YourObject3Type getObject2() {
        return new YourObject3Type();
    }
}

class YourObject3Type {
    public YourPropertyType getObject3() {
        return new YourPropertyType();
    }
}

class YourPropertyType {
    public String getProperty() {
        return "PropertyValue";
    }
}