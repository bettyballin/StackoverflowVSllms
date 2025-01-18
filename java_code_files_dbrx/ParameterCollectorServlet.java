import java.lang.String;

public class ParameterCollectorServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2"); // Continue for all input fields

        FormBean formBean = new FormBean();
        formBean.setParam1(param1);
        formBean.setParam2(param2); // Continue setting data from other parameters
        // Rest of your handling code using the populated form bean...
    }
    public static void main(String[] args) {
    }
}

class FormBean {
    private String param1;
    private String param2;
    // Continue for all input fields

    public void setParam1(String param1) {
        this.param1 = param1;
    }
    public void setParam2(String param2) {
        this.param2 = param2;
    }
    // Continue setting data from other parameters
}

// Minimal definitions for missing classes

class HttpServletRequest {
    public String getParameter(String name) {
        return null; // Simplistic implementation
    }
}

class HttpServletResponse {
    // Empty stub
}

class ServletException extends Exception {
    // Empty stub
}

class IOException extends Exception {
    // Empty stub
}