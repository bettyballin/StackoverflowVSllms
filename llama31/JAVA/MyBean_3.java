import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

public class MyBean_3 {
    private String selectedValue;
    private List<SelectItem> items;

    public MyBean() {
        items = new ArrayList<>();
        items.add(new SelectItem("value1", "Label 1"));
        items.add(new SelectItem("value2", "Label 2"));
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<SelectItem> getItems() {
        return items;
    }

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        // Here you can access and manipulate myBean and its properties
        System.out.println(myBean.getItems());
    }
}