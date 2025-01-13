import javax.servlet.http.HttpServletRequest;

public class ParamHelper {
    public static String getParam(HttpServletRequest request, String name, int index) {
        return request.getParameter(name + "_" + index);
    }

    public static void main(String[] args) {
    }
}