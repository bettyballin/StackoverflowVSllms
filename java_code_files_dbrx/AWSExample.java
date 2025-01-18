import java.net.URL;
import java.util.Date;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

public class AWSExample {
    public static void main(String[] args) {
        // Generate presigned URL for putObject command
        String keyName = "yourfile_name"; // Replace with your file name
        Date expiration = new Date();
        long msec = expiration.getTime();
        msec += 1000 * 60 * 60; // Add 1 hour (3600 seconds) to current time.
        expiration.setTime(msec);   // Update expiration time

        // Generate presigned URL for PUT request to our S3 bucket
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest("your_bucket", keyName)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration); // Expiry set here

        // Initialize AmazonS3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();

        URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
        // Now pass this URL back to client-side/browser, which can use it for PUT Object request

        // For demonstration, print the URL
        System.out.println("Pre-Signed URL: " + url.toString());
    }
}