/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public class Main_682 {
    public static void main(String[] stringArray) throws Exception {
        Object obj = Class.forName("com.mypackage.Handler").newInstance();
        Method method = obj.getClass().getMethod("myMethod", String[].class);
        String[] stringArray2 = new String[]{"value1", "value2"};
        method.invoke(obj, new Object[]{stringArray2});
    }
}
