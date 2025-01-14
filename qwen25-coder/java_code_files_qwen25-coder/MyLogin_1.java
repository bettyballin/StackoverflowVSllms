import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
// Managed Bean
@ManagedBean
@RequestScoped
public class MyLogin_1 {
    private String username = "some_value";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) {
    }
}