/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class ParamHelper {
    public static String getParam(HttpServletRequest httpServletRequest, String string, int n) {
        return httpServletRequest.getParameter(string + "_" + n);
    }

    public static void main(String[] stringArray) {
    }
}
