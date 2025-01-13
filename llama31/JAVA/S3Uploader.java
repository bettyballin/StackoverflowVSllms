import java.lang.String;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class S3Uploader {
  public void uploadFile(String file, String fileType) {
    String url = "/s3proxy"; // URL of your proxy servlet
    RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
    builder.setHeader("Content-Type", fileType);

    try {
      Request request = builder.sendRequest(file, new RequestCallback() {
        @Override
        public void onResponseReceived(Request request, Response response) {
          if (response.getStatusCode() == 200) {
            System.out.println("File uploaded successfully!");
          } else {
            System.out.println("Error uploading file: " + response.getStatusCode());
          }
        }

        @Override
        public void onError(Request request, Throwable exception) {
          System.out.println("Error uploading file: " + exception.getMessage());
        }
      });
    } catch (RequestException e) {
      System.out.println("Error sending request: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    S3Uploader uploader = new S3Uploader();
    String fileContent = "This is a sample file content.";
    String fileType = "text/plain";
    uploader.uploadFile(fileContent, fileType);
  }
}