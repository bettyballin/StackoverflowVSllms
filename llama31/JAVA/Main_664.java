import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.SelectObjectContentRequest;
import software.amazon.awssdk.services.s3.model.ExpressionType;
import software.amazon.awssdk.services.s3.model.OutputSerialization;
import software.amazon.awssdk.services.s3.model.CSVOutput;

import java.util.Arrays;
import java.util.List;

public class Main_664 {
    public static void main(String[] args) {
        S3Client s3Client = S3Client.create();

        String bucketName = "your-bucket";
        String zipFile = "images.zip";
        List<String> fileList = Arrays.asList("image1.jpg", "image2.jpg");

        SelectObjectContentRequest request = SelectObjectContentRequest.builder()
                .bucket(bucketName)
                .key(zipFile)
                .expression("SELECT * FROM S3Object WHERE key IN ('" + String.join("', '", fileList) + "')")
                .expressionType(ExpressionType.SQL)
                .outputSerialization(OutputSerialization.builder().csv(CSVOutput.builder().build()).build())
                .build();

        s3Client.selectObjectContent(request);
    }
}