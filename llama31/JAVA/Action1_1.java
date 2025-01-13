import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Action1_1_1 extends ActionSupport implements ModelDriven<MyModel> {
    private MyModel model = new MyModel();

    public String execute() {
        // set model values
        model.setParam1("some value");
        return SUCCESS;
    }

    public MyModel getModel() {
        return model;
    }
}

public class Action2 extends ActionSupport implements ModelDriven<MyModel> {
    private MyModel model = new MyModel();

    public String execute() {
        // access model values
        String param1 = model.getParam1();
        return SUCCESS;
    }

    public MyModel getModel() {
        return model;
    }

    public static void main(String[] args) {
        // Create an instance of Action1_1 and call its execute method
        Action1_1 action1 = new Action1_1();
        action1.execute();

        // Create an instance of Action2 and call its execute method
        Action2 action2 = new Action2();
        action2.getModel().setParam1(action1.getModel().getParam1());
        action2.execute();
    }
}

// Define the MyModel class
class MyModel {
    private String param1;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }
}