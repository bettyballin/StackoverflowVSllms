import java.lang.String;
import java.lang.Integer;

interface ViewPreparer {
    void execute(PreparationContext context) throws Exception;
}

class PreparationContext {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void putAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}

public class PaginationViewPreparer implements ViewPreparer {
    @Override
    public void execute(PreparationContext context) throws Exception {
        // Assuming 'content' and 'totalContent' are already set by the controller
        Object content = context.getAttribute("content");
        Integer totalContent = (Integer) context.getAttribute("totalContent");

        if (content != null && totalContent != null) {
            String formattedPaginationInfo = "Page X of " + totalContent + " Posts";
            context.putAttribute("paginationInfo", formattedPaginationInfo);
        }
    }

    public static void main(String[] args) {
    }
}