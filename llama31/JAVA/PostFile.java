import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PostFile {
    public static void main(String[] args) throws Exception {
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost("http://localhost:9002/upload.php");

        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("userfile", new File("c:/TRASH/zaba_1.jpg"));
        HttpEntity reqEntity = entityBuilder.build();

        httppost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();

        System.out.println(response.getStatusLine());
        if (resEntity != null) {
            System.out.println(EntityUtils.toString(resEntity));
        }
    }
}