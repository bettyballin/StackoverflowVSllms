import com.opensymphony.xwork2.ActionSupport;

// MyAction.java
public class MyAction_5_5 extends ActionSupport {
    private String selectedValue;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String execute() {
        // ...
        return SUCCESS;
    }

    public static void main(String[] args) {
    }
}