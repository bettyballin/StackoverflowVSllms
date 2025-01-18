import java.util.List;
import java.util.ArrayList;

public class ItemController {
    private int currentVersion = 0; // current version on server, update it every time change occurs
    List<Item> items;

    public ItemController() {
        items = new ArrayList<>();
    }

    public void addOrUpdate(Item item) {
        if (!items.contains(item)) {
            items.add(item);
            currentVersion++;
        } else {
            int pos = items.indexOf(item);
            items.set(pos, item);
            currentVersion++;
        }
    }

    public void remove(Item item)  {
        if (items.remove(item))
            currentVersion++;
    }

	public static void main(String[] args) {
	}
}

class Item {
    // Empty class
}