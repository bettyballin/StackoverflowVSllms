import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

public class CustomAction {
    IAction action = new Action("My Action", IAction.AS_PUSH_BUTTON) {
        @Override
        public void run() {
            // Handle action behavior
            System.out.println("Action executed");
        }
    };

    public static void main(String[] args) {
        CustomAction customAction = new CustomAction();
        customAction.action.run();
    }
}