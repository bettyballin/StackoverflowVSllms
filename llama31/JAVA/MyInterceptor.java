import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof DwrHttpServletRequest) {
            DwrHttpServletRequest dwrRequest = (DwrHttpServletRequest) request;
            Map<String, String[]> parameterMap = dwrRequest.getParameterMap();
            String groupId = parameterMap.get("groupId")[0];
            String groupName = parameterMap.get("groupName")[0];
            // do something with groupId and groupName
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }

    public static void main(String[] args) {
    }
}

class DwrHttpServletRequest extends HttpServletRequest {
    // You need to implement the methods of HttpServletRequest or extend an existing implementation
    @Override
    public Map<String, String[]> getParameterMap() {
        // You need to implement this method
        return null;
    }
}