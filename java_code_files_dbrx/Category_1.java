import java.util.HashMap;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "category") // Use @Named if CDI is used instead of managed beans
@RequestScoped
public class Category_1 implements Serializable {
    private HashMap<String, HashMap<String, Integer>> categories;
    // getter and setter for categories

    public static void main(String[] args) {
    }
}