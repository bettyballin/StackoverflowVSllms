import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

// MyView.java (Java code)
public class MyView_2_2 extends Composite {
  private HTMLPanel htmlPanel;

  public MyView_2() {
    htmlPanel = new HTMLPanel("<div><label>Name:</label><input type='text'></div>");
    initWidget(htmlPanel);
  }

	public static void main(String[] args) {
	}
}