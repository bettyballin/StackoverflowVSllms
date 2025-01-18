// File: org/eclipse/osgi/util/NLS.java
package org.eclipse.osgi.util;

public class NLS {
    public static String bind(String message, Object... bindings) {
        for (int i = 0; i < bindings.length; i++) {
            message = message.replace("{" + i + "}", bindings[i].toString());
        }
        return message;
    }
}