import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class RoleVisibilityProcessor {
    List<Map<String, Object>> rolesWithVisibility = new ArrayList<>();
    public RoleVisibilityProcessor() {
       for (Role role : resource.getValue().getRs()) {
           boolean isVisible = role.isVisible((AuthUser) session.getAttribute("authUser"));
           Map<String, Object> roleInfo = new HashMap<>();
           roleInfo.put("role", role);
           roleInfo.put("isVisible", isVisible);
           rolesWithVisibility.add(roleInfo);
       }
       request.setAttribute("rolesWithVisibility", rolesWithVisibility);
    }
    public static void main(String[] args) {
    }
}