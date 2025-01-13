import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

public class S3ProxyServlet extends HttpServlet {
  private static final String S3_BUCKET_NAME = "your-bucket-name";
  private static final String AWS_ACCESS_KEY = "your-access-key";
  private static final String AWS_SECRET_KEY = "your-secret-key";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String file = req.getParameter("file");
    String fileType = req.getParameter("fileType");

    URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
    FetchOptions options = FetchOptions.Builder.withDefaults();

    String s3Url = "https://" + S3_BUCKET_NAME + ".s3.amazonaws.com/" + file;
    options.setHeader("Authorization", "AWS " + AWS_ACCESS_KEY + ":" + AWS_SECRET_KEY);
    options.setHeader("Content-Type", fileType);

    InputStream inputStream = req.getInputStream();
    OutputStream outputStream = resp.getOutputStream();

    fetchService.fetch(s3Url, inputStream, outputStream, options);
  }

  public static void main(String[] args) {
  }
}