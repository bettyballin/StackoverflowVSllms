/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/adminnotes/*"})
public class AdminNotesServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String string = httpServletRequest.getPathInfo().substring(1);
        if (!this.hasAccessToAdminNotes(httpServletRequest, string)) {
            httpServletResponse.setStatus(404);
            return;
        }
        if (!this.adminNotesExistForUser(string)) {
            httpServletResponse.setStatus(404);
        }
    }

    private boolean hasAccessToAdminNotes(HttpServletRequest httpServletRequest, String string) {
        return true;
    }

    private boolean adminNotesExistForUser(String string) {
        return true;
    }

    public static void main(String[] stringArray) {
    }
}
