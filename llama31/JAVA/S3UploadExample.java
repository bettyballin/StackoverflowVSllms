import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3UploadExample {
    public static void main(String[] args) {
        // Placeholder for the file bytes
        byte[] fileBytes = "Hello, S3!".getBytes();

        // Create an S3 client
        S3Client s3Client = S3Client.create();

        // Create a PutObjectRequest
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket("your-bucket-name")
                .key("path/to/your/file")
                .contentType("application/octet-stream")
                .build();

        // Create a RequestBody from fileBytes
        RequestBody requestBody = RequestBody.fromBytes(fileBytes);

        try {
            // Upload the object to S3
            s3Client.putObject(request, requestBody);
            System.out.println("File uploaded successfully!");
        } catch (Exception e) {
            System.err.println("Failed to upload file: " + e.getMessage());
        } finally {
            // Close the S3 client to free up resources
            s3Client.close();
        }
    }
}