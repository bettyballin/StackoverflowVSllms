import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;

public interface MyCssResource extends com.google.gwt.resources.client.CssResource {
  String myStyle();
}

public class MyCssResourceImpl implements MyCssResource {
  @Override
  public String myStyle() {
    return "my-style";
  }
}

public class MyWidget extends Composite {
  interface MyWidgetUiBinder extends UiBinder<Widget, MyWidget> {}
  private static MyWidgetUiBinder uiBinder = GWT.create(MyWidgetUiBinder.class);

  @UiField MyCssResource css;
  @UiField Button myButton;

  public MyWidget() {
    uiBinder.createAndBindUi(this);
  }

  @UiHandler("myButton")
  void onMyButtonClicked(ClickEvent event) {
    myButton.addStyleName(css.myStyle());
  }

  public static void main(String[] args) {
  }
}