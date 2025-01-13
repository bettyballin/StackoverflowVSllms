import io.jcasbin.JCasbin;
import io.jcasbin.model.Model;

public class Main_359 {
    public static void main(String[] args) {
        JCasbin enforcer = new JCasbin();
        Model model = enforcer.getModel();
        model.loadPolicy("path/to/policy");
    }
}