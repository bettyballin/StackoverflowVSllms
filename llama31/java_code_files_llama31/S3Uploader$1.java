/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.http.client.Request
 *  com.google.gwt.http.client.RequestCallback
 *  com.google.gwt.http.client.Response
 */
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

class S3Uploader.1
implements RequestCallback {
    S3Uploader.1(S3Uploader s3Uploader) {
    }

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
}
