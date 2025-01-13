/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;

public class UserRoleUtil {
    public static String[] getUserRoles(HttpServletRequest httpServletRequest) {
        Principal principal = httpServletRequest.getUserPrincipal();
        if (principal == null) {
            return new String[0];
        }
        String[] stringArray = ((YourPrincipalImplemention)principal).getRoles();
        return stringArray;
    }

    public static void main(String[] stringArray) {
        String[] stringArray2;
        HttpServletRequest httpServletRequest = null;
        for (String string : stringArray2 = UserRoleUtil.getUserRoles(httpServletRequest)) {
            System.out.println(string);
        }
    }
}
