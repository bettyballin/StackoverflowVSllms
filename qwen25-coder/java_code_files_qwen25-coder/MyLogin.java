import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

// Managed Bean with Session Scope
@ManagedBean
@SessionScoped
public class MyLogin implements Serializable {
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