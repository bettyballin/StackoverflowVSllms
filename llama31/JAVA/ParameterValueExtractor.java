import javax.servlet.http.HttpServletRequest;

public class ParameterValueExtractor {
    public static void main(String[] args) {
        HttpServletRequest request = null; // Initialize request variable
        String selectedValue = request.getParameter("titulo");
    }
}