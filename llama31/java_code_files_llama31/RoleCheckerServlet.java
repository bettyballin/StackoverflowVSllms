/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import java.util.Collection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleCheckerServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            InitialContext initialContext = new InitialContext();
            String string = (String)initialContext.lookup("java:module/ModuleName");
            Context context = (Context)initialContext.lookup("java:module/" + string);
            Collection collection = (Collection)context.lookup("java:security/roles");
            System.out.println(collection);
        }
        catch (NamingException namingException) {
            // empty catch block
        }
    }

    public static void main(String[] stringArray) {
    }
}
