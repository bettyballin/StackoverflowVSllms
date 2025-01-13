import javax.servlet.http.HttpServletRequest;

public class ServletInitializer {
    public void init(HttpServletRequest request) {
        request.setCharacterEncoding("UTF-8");
    }

    public static void main(String[] args) {
        // This main method is required for the class to be executable with javac.
        // However, it doesn't make sense in this context because we don't have an HttpServletRequest object.
        System.out.println("This class is not meant to be run as a standalone application.");
    }
}