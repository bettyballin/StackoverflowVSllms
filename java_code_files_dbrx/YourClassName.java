import javax.servlet.http.HttpServletRequest;

public class YourClassName {

    public boolean behindProxy(HttpServletRequest request) {
        final String[] FORWARDED_KEYS = {"X-forwarded", "vias"};
        for (String key : FORWARDED_KEYS){
            String headerValue = request.getHeader(key);
            if (headerValue != null && !headerValue.isEmpty()){
                return true;
            }
            // ...
        }
        // You can also check IP ranges, specific headers or ports as mentioned above, etc.
        return false;
    }

}