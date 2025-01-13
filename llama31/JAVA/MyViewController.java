// MyViewController.java
import java.lang.String;

public class MyViewController {
    private ButtonHelper buttonHelper;
    private TableHelper tableHelper;

    public MyViewController() {
        buttonHelper = new ButtonHelper();
        tableHelper = new TableHelper();
    }

    public void handleButtonClick() {
        buttonHelper.handleClick();
    }

    public void handleTableSelection() {
        tableHelper.handleSelection();
    }

    public static void main(String[] args) {
        MyViewController controller = new MyViewController();
        controller.handleButtonClick();
        controller.handleTableSelection();
    }
}

// ButtonHelper.java
public class ButtonHelper {
    public void handleClick() {
        System.out.println("Button clicked");
    }
}

// TableHelper.java
public class TableHelper {
    public void handleSelection() {
        System.out.println("Table selection changed");
    }
}