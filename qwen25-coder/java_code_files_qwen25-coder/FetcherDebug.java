import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FetcherDebug {
    public static void main(String[] args) {
        try {
            Class<?> fetcherInfoClass = Class.forName("sun.awt.image.FetcherInfo");
            Method method = fetcherInfoClass.getDeclaredMethod("getFetcherInfo");
            method.setAccessible(true);
            Object fetcherInfoInstance = method.invoke(null);
            System.out.println("FetcherInfo instance obtained: " + fetcherInfoInstance);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}