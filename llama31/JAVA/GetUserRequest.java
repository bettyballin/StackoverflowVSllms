import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Service
public class UserService {
  
  @PayloadRoot(namespace = "http://example.com/services", localPart = "getUserRequest")
  public GetUserResponse getUser(GetUserRequest request) {
    GetUserResponse response = new GetUserResponse();
    // Implementation goes here, e.g.:
    response.setUser("John Doe");
    return response;
  }

  @XmlRootElement(name = "getUserRequest", namespace = "http://example.com/services")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class GetUserRequest {
    
    @XmlElement(name = "userId", namespace = "http://example.com/services")
    private String userId;

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }
  }

  @XmlRootElement(name = "getUserResponse", namespace = "http://example.com/services")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class GetUserResponse {
    
    @XmlElement(name = "user", namespace = "http://example.com/services")
    private String user;

    public String getUser() {
      return user;
    }

    public void setUser(String user) {
      this.user = user;
    }
  }
}