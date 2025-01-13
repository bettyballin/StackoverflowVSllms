import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class Main_153 {
    public static void main(String[] args) {
        // Create an instance of the COM component
        ActiveXComponent component = new ActiveXComponent("MyComComponent");
        Dispatch dispatch = component.getObject();

        // Call a method on the COM component
        dispatch.call("MyMethod");
    }
}