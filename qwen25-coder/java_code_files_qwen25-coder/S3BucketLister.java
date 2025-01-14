import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.regions.Regions;

public class S3BucketLister {
    // Example of using AWS SDK for Java to access S3 (autofetch credentials from EC2 IMDS)
    AmazonS3 s3Client = AmazonS3Client.builder()
        .withRegion(Regions.US_EAST_1)
        .build();

    {
        s3Client.listBuckets();
    }

    public static void main(String[] args) {
    }
}