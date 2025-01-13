import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionCacheManager {
    // Set a cache item in the user's session
    public void setCacheItem(HttpServletRequest request, Object cachedValue) {
        HttpSession session = request.getSession();
        session.setAttribute("cachedItem", cachedValue);
    }

    // Retrieve the cache item from the user's session
    public Object getCacheItem(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("cachedItem");
    }

    public static void main(String[] args) {
    }
}