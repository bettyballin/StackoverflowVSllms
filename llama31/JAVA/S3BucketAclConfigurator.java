import java.util.List;
import java.util.ArrayList;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Permission;

public class S3BucketAclConfigurator {
    public static void main(String[] args) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();

        String bucketName = "your-bucket-name"; // replace with your bucket name

        BucketCrossOriginConfiguration configuration = new BucketCrossOriginConfiguration();
        List<Grant> grants = new ArrayList<>();
        grants.add(new Grant(GroupGrantee.AllUsers, Permission.Read));
        grants.add(new Grant(GroupGrantee.AllUsers, Permission.Write));
        AccessControlList acl = new AccessControlList();
        acl.setOwner(s3Client.getS3AccountOwner());
        acl.setGrants(grants);
        s3Client.setBucketAcl(bucketName, acl);
    }
}