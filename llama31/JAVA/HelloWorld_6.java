import java.lang.String;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorld_6 implements EntryPoint {
  public void onModuleLoad() {
    Label label = new Label("Hello, World!");
    RootPanel.get().add(label);
  }

	public static void main(String[] args) {
	}
}