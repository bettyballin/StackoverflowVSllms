package sun.awt.image; // Note this package might vary depending on the JDK version or implementation
import java.lang.reflect.*;

public class AccessFetcherInfo {
    private static Method getFetcherInfoMethod = null;

    // Get FetcherInfo instance (static method, so pass null)
    public static Object getFetcherInfoInstance() throws Exception {
        if (getFetcherInfoMethod == null) {
            Class<?> fetcherInfoClass = Class.forName("sun.awt.image.FetcherInfo"); // Replace with the fully qualified name for your JDK version or implementation
            getFetcherInfoMethod = fetcherInfoClass.getDeclaredMethod(
                "getFetcherInfo", new Class[0]); // Method name & argument types list
        }
        // Set accessible and call the method with null, since it's a static method.
        getFetcherInfoMethod.setAccessible(true);
        return getFetcherInfoMethod.invoke(null);
    }
}