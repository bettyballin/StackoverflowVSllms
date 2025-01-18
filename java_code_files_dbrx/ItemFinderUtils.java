import java.util.List;
import java.lang.reflect.Method;

public class ItemFinderUtils {
    public Object findItemByName(List<Object> items, String name) {
        if (items != null && items.size() > 0)
            return items.stream().filter(item -> {
                try {
                    Method getNameMethod = item.getClass().getMethod("getName");
                    String itemName = (String) getNameMethod.invoke(item);
                    return itemName.equalsIgnoreCase(name);
                } catch (Exception e) {
                    return false;
                }
            }).findAny().orElse(null);
        else
            return null; // There are no items in the list to search from!
    }
    public static void main(String[] args) {
    }
}