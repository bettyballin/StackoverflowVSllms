import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class MenuItemStateManager {
    public static void setMenuStateCookie(HttpServletResponse response, JSONObject menuState) {
        // Set the menu state cookie
        Cookie cookie = new Cookie("menuState", menuState.toString());
        response.addCookie(cookie);
    }

    public static JSONObject getMenuStateCookie(HttpServletRequest request) {
        // Get the menu state cookie
        Cookie[] cookies = request.getCookies();
        JSONObject menuState = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("menuState")) {
                menuState = new JSONObject(cookie.getValue());
                break;
            }
        }
        return menuState;
    }

    public static void main(String[] args) {
        // Example usage:
        // HttpServletRequest request = ...;
        // HttpServletResponse response = ...;
        // JSONObject menuState = new JSONObject();
        // setMenuStateCookie(response, menuState);
        // JSONObject retrievedMenuState = getMenuStateCookie(request);
    }
}