import java.lang.String;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

// MyComponent.java
public class MyComponent extends Composite {
    private Label label;

    public MyComponent() {
        label = new Label("Hello World!");
        initWidget(label);
    }

	public static void main(String[] args) {
	}
}