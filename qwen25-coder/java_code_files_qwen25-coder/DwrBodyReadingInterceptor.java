import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

public class DwrBodyReadingInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the content type is JSON
        String contentType = request.getContentType();
        if (contentType != null && contentType.startsWith("application/json")) {
            StringBuilder requestData = new StringBuilder();
            try (BufferedReader reader = request.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    requestData.append(line);
                }
            }

            // Parse the JSON data
            DwrRequestData data = objectMapper.readValue(requestData.toString(), DwrRequestData.class);

            // Access the parsed data
            System.out.println("GroupId: " + data.getGroupId());
            System.out.println("GroupName: " + data.getGroupName());

            // Optionally, you can modify the request here or pass data to the controller
        }

        return true; // Continue with the execution of other interceptors and the target handler
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Do nothing
    }

}

class DwrRequestData {
    private String groupId;
    private String groupName;

    // Getters and setters
    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public static void main(String[] args) {
    }
}