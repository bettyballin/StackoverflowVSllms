import java.util.List;
import java.util.ArrayList;

public class ItemManager {

    private List<Item> m_items = new ArrayList<>();

    public Item getItemByIdx(int idx) {
        if ((idx < 0) || (idx >= m_items.size())) {
            throw new IllegalArgumentException("Invalid index");
        }
        return m_items.get(idx);
    }
}

class Item {
    // Item class implementation
}