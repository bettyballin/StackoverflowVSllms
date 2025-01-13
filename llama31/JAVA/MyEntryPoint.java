import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;

public class MyEntryPoint implements EntryPoint {
  public void onModuleLoad() {
    // Create a request to the server
    RequestBuilder request = new RequestBuilder(RequestBuilder.GET, "/my-service");
    request.setHeader("Content-Type", "application/x-www-form-urlencoded");
    request.setRequestData("param1=value1&param2=value2");

    // Send the request and handle the response
    request.sendRequest(null, new RequestCallback() {
      public void onResponseReceived(Request request, Response response) {
        if (200 == response.getStatusCode()) {
          // Update the contents of the div
          DOM.getElementById("myDiv").setInnerHTML(response.getText());
        }
      }

      public void onError(Request request, Throwable exception) {
        // Handle the error
      }
    });
  }

  public static void main(String[] args) {
    // This main method is not necessary for GWT applications
  }
}