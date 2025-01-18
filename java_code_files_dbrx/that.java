import java.io.IOException;
import java.util.Map;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class that extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming MyBean is your bean class that you want to populate.
        MyBean myBean = new MyBean();

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            // Assuming setValue() is the method through which you want to set property value from a string. Modify accordingly.
            myBean.setValue(entry.getKey(), Arrays.toString(entry.getValue()));
        }
    }

    public static void main(String[] args) {
    }
}