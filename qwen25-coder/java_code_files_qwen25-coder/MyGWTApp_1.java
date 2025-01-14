import java.lang.String;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyGWTApp_1 implements EntryPoint {

    public void onModuleLoad() {
        Button sendRequestButton = new Button("Send Request");
        sendRequestButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // Here you would implement the logic to send a request using your in-house CORBA libraries
                Window.alert("Request sent!");
            }
        });

        RootPanel.get().add(sendRequestButton);
    }

	public static void main(String[] args) {
	}
}