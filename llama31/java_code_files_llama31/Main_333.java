/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.MediaType
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Main_333 {
    public static void main(String[] stringArray) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String string = "your_client_id";
        String string2 = "your_client_secret";
        String string3 = "https://your-api.com/token";
        String string4 = "client_credentials";
        HttpEntity httpEntity = new HttpEntity((Object)String.format("grant_type=%s&client_id=%s&client_secret=%s", string4, string, string2), (MultiValueMap)httpHeaders);
        String string5 = (String)restTemplate.postForObject(string3, (Object)httpEntity, String.class, new Object[0]);
        System.out.println(string5);
    }
}
