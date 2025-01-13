import javax.servlet.http.HttpServletResponse;

public class CacheDisabler {
    public static void disableCache(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
    }

    public static void main(String[] args) {
        // You would typically call disableCache from a servlet, passing in the HttpServletResponse object.
        // For example:
        // HttpServletResponse response = ...;
        // CacheDisabler.disableCache(response);
    }
}