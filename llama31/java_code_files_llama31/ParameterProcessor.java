/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

public class ParameterProcessor {
    public static void processParameters(HttpServletRequest httpServletRequest) {
        Enumeration enumeration = httpServletRequest.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            String[] stringArray = httpServletRequest.getParameterValues(string);
        }
    }

    public static void main(String[] stringArray) {
    }
}
