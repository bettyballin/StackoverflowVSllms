import java.lang.String;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.MyComponent;

// MyModule.java
public class MyModule_1_1 extends EntryPoint {
    public void onModuleLoad() {
        MyComponent component = new MyComponent();
        RootPanel.get().add(component);
    }

	public static void main(String[] args) {
	}
}