import java.util.List;
import java.util.ArrayList;

public class MyBean {
  private List<MyRow> data;

  public List<MyRow> getData() {
    return data;
  }

  public MyBean() {
    data = new ArrayList<>();
  }

  public class MyRow {
    private boolean selected;
    private String value;

    public boolean isSelected() {
      return selected;
    }

    public void setSelected(boolean selected) {
      this.selected = selected;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    MyBean myBean = new MyBean();
    MyBean.MyRow row = myBean.new MyRow();
    row.setValue("Test");
    row.setSelected(true);
    myBean.getData().add(row);
  }
}