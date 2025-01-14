import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class UploadFileServlet extends HttpServlet {
    private static final String BUCKET_NAME = "your.bucket.name";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (InputStream fileContent = request.getInputStream()) {
            File tempFile = createTempFile(request);
            IOUtils.copy(fileContent, new FileOutputStream(tempFile));
            
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("your-access-key-id", "your-secret-access-key");
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion("us-west-2") // Specify your region
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .build();

            s3Client.putObject(new PutObjectRequest(BUCKET_NAME, tempFile.getName(), tempFile));
            
            response.getWriter().println("Upload successful");
        } catch (Exception e) {
            response.getWriter().println("Upload failed: " + e.getMessage());
        }
    }

    private File createTempFile(HttpServletRequest request) throws IOException {
        String fileName = request.getHeader("file-name"); // Assuming file name is sent as a header
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        return File.createTempFile(fileName, ".tmp", tempDir);
    }

    public static void main(String[] args) {
    }
}