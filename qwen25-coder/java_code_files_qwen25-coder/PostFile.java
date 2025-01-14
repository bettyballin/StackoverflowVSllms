import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostFile {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost uploadFile = new HttpPost("http://localhost:9002/upload.php");

            File file = new File("c:/TRASH/zaba_1.jpg");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody(
                "userfile",
                file,
                ContentType.DEFAULT_BINARY,
                file.getName()
            );

            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);

            System.out.println("executing request " + uploadFile.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(uploadFile);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println(EntityUtils.toString(resEntity));
                }
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}