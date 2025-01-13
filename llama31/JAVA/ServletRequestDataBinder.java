import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;

public class ServletRequestDataBinder {
    @Override
    public void onBind(HttpServletRequest request, Object command, BindException errors) {
        // Add data to the model
        Map<String, Object> map = new HashMap<>();
        // populate the map...
        request.setAttribute("myData", map);
    }

    public static void main(String[] args) {
    }
}