/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.http.client.Request
 *  com.google.gwt.http.client.RequestBuilder
 *  com.google.gwt.http.client.RequestCallback
 *  com.google.gwt.http.client.RequestException
 *  com.google.gwt.http.client.Response
 */
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class S3Uploader {
    public void uploadFile(String string, String string2) {
        String string3 = "/s3proxy";
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, string3);
        requestBuilder.setHeader("Content-Type", string2);
        try {
            Request request = requestBuilder.sendRequest(string, new RequestCallback(this){

                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        System.out.println("File uploaded successfully!");
                    } else {
                        System.out.println("Error uploading file: " + response.getStatusCode());
                    }
                }

                public void onError(Request request, Throwable throwable) {
                    System.out.println("Error uploading file: " + throwable.getMessage());
                }
            });
        }
        catch (RequestException requestException) {
            System.out.println("Error sending request: " + requestException.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        S3Uploader s3Uploader = new S3Uploader();
        String string = "This is a sample file content.";
        String string2 = "text/plain";
        s3Uploader.uploadFile(string, string2);
    }
}
