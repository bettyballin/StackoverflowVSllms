import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;

@Stateless
@SessionScoped
public class SharedSessionBean implements Serializable {
    // Store session data here

    public static void main(String[] args) {
    }
}