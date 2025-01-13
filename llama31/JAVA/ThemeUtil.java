import javax.servlet.http.HttpSession;

public class ThemeUtil {
    String theme;

    public ThemeUtil(HttpSession session) {
        this.theme = (String) session.getAttribute("theme");
    }

    public static void main(String[] args) {
    }
}