import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Dummy annotations to allow compilation without external libraries
@interface ManagedBean {}
@interface ViewScoped {}

@ManagedBean
@ViewScoped
public class DataTableBean implements Serializable {
    private List<Item> items = new ArrayList<>();
    private List<String> selectedItemsIds; // or directly use a List<Item>

    public DataTableBean() {
        // Populate your list with Item objects
        for (int i = 1; i <= 5; i++) {
            items.add(new Item(i, "Item " + i));
        }
    }

    public void submit() {
        for (Item item : items) {
            if (item.isSelected()) {
                // Perform validation only on selected items
                validate(item);
            }
        }
    }

    private void validate(Item item) {
        // Implement your validation logic here
        if (item.getValue().isEmpty()) {
            // Add FacesMessage or throw a custom exception for invalid data
        }
    }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
    public List<String> getSelectedItemsIds() { return selectedItemsIds; }
    public void setSelectedItemsIds(List<String> selectedItemsIds) { this.selectedItemsIds = selectedItemsIds; }

    // Item class
    public static class Item {
        private int id;
        private String value;
        private boolean selected;

        public Item(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
        public boolean isSelected() { return selected; }
        public void setSelected(boolean selected) { this.selected = selected; }
    }

    public static void main(String[] args) {
        DataTableBean bean = new DataTableBean();
        bean.submit();
    }
}