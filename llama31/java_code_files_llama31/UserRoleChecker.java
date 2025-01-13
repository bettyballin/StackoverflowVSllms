/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class UserRoleChecker {
    public String[] getUserRoles(HttpServletRequest httpServletRequest) {
        String[] stringArray;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : stringArray = new String[]{"admin", "moderator", "user"}) {
            if (!httpServletRequest.isUserInRole(string)) continue;
            arrayList.add(string);
        }
        return arrayList.toArray(new String[0]);
    }

    public static void main(String[] stringArray) {
        Object var1_1 = null;
        System.out.println("This is a simulation and doesn't actually check user roles.");
    }
}
