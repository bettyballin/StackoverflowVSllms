import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class CloudStorageExample {
    public static void main(String[] args) throws Exception {
        // Create a storage service object using credentials from environment variable
        Storage storage = StorageOptions.getDefaultInstance().getService();

        // Name of the bucket where you want to save your file
        String bucketName = "your-bucket-name";

        // Name of the file in the bucket
        String fileName = "your-file.csv";

        // Create a BlobId object for your file
        BlobId blobId = BlobId.of(bucketName, fileName);

        // Create a BlobInfo object to define the properties of your new file
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        // Upload the file content to Google Cloud Storage
        String contents = "name,age\nAlice,21\nBob,23"; // Your CSV data
        storage.create(blobInfo, contents.getBytes());

        // Download and print the file content
        Blob blob = storage.get(bucketName, fileName);
        byte[] bytes = blob.getContent();
        System.out.println(new String(bytes));

        // Update the file content (for demonstration purposes)
        String updatedContents = "name,age\nAlice,21\nBob,24";
        blob.update(BlobInfo.newBuilder(blobId).build(), updatedContents.getBytes());
    }
}