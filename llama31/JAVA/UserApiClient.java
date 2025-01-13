import java.lang.String;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

public class UserApiClient {
    // GWT client-side code
    public static void main(String[] args) {
        RequestBuilder request = new RequestBuilder(RequestBuilder.GET, "/api/users");
        request.setHeader("Accept", "application/json");
        request.sendRequest(null, new RequestCallback() {
            @Override
            public void onError(Request request, Throwable exception) {
                // Handle error
            }

            @Override
            public void onResponseReceived(Request request, Response response) {
                // Handle response
            }
        });
    }
}