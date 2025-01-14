// File: Validate.java
package org.apache.commons.lang3;

public class Validate {
    public static <T> T notNull(final T object, final String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }
}

// File: MyClass.java
import org.apache.commons.lang3.Validate;
import org.w3c.dom.Element;
import java.net.URL;

public class MyClass {

    public URL extractUrl(Element element) throws Exception {
        Validate.notNull(element, "element cannot be null");
        // rest of the code...
        return null; // Placeholder return to make the code compile
    }

}