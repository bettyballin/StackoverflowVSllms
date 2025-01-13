import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class RoleCheckerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context ctx = new InitialContext();
            String moduleName = (String) ctx.lookup("java:module/ModuleName");
            Context moduleCtx = (Context) ctx.lookup("java:module/" + moduleName);
            Collection<String> roles = (Collection<String>) moduleCtx.lookup("java:security/roles");
            // Do something with the roles
            System.out.println(roles);
        } catch (NamingException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
    }
}