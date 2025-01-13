import java.util.HashMap;
import java.util.Map;

// Simulate Action class
class Action {
    public void execute() {}
}

// Simulate ActionForward class
class ActionForward {
    private String name;

    public ActionForward(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Simulate ActionMapping class
class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward(name);
    }
}

// Simulate HttpServletRequest class
class HttpServletRequest {
    private Map<String, Object> attributes = new HashMap<>();
    private Map<String, String[]> parameters = new HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setParameter(String name, String[] values) {
        parameters.put(name, values);
    }

    public String[] getParameterValues(String name) {
        return parameters.get(name);
    }
}

// Simulate HttpServletResponse class
class HttpServletResponse {}

// Simulate ActionForm class
class ActionForm {}

public class MyAction_3_3 extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        // assume 'map' is your HashMap object
        HashMap<String, String> map = (HashMap<String, String>) request.getAttribute("map");

        // assume 'keys' is your set of keys
        String[] keys = request.getParameterValues("keys");

        for (String key : keys) {
            if (map.containsKey(key)) {
                // key is present in the hashmap, perform task
                System.out.println("Key " + key + " is present in the map.");
                // perform task here
            } else {
                // key is not present in the hashmap, perform alternative task
                System.out.println("Key " + key + " is not present in the map.");
                // perform alternative task here
            }
        }

        return mapping.findForward("success");
    }

    public static void main(String[] args) {
        MyAction_3 action = new MyAction_3();
        ActionMapping mapping = new ActionMapping();
        ActionForm form = new ActionForm();
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        request.setAttribute("map", map);

        String[] keys = {"key1", "key3"};
        request.setParameter("keys", keys);

        action.execute(mapping, form, request, response);
    }
}