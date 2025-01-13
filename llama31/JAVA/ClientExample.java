import java.lang.String;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class User {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

public class ClientExample {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.foo.com/users");
        
        User user = new User();
        user.setName("foo");
        user.setSurname("foo");
        
        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        
        System.out.println(response.getStatus());
    }
}