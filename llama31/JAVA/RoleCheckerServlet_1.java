import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class RoleCheckerServlet_1_1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Collection<String> declaredRoles = context.getServletRegistration(this.getServletName()).getServletSecurity().getDeclaredRoles();
        // Do something with the declared roles
        System.out.println(declaredRoles);
    }

    public static void main(String[] args) {
    }
}