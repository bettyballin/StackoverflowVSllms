import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDetailController {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("Userdetail", getUserdetail());
    }

    public static void main(String[] args) {
        // You can't directly run a servlet from the main method.
        // You need to deploy it to a servlet container like Tomcat.
    }

    private Object getUserdetail() {
        // You need to implement this method to return the user details.
        return null;
    }
}