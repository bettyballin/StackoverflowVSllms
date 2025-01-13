import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class MyServiceClient_1_1 {

    public static void main(String[] args) {
        MyServiceClient client = Feign.builder()
            .decoder(new GsonDecoder())
            .encoder(new GsonEncoder())
            .target(MyServiceClient.class, "https://api.example.com");
        
        User user = client.getUser(1L);
    }
}

interface MyServiceClient {
    User getUser(long id);
}

class User {
    // Define the User class structure here, for example:
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}