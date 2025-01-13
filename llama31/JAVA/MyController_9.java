import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

public class MyController_9_9 {
    @RequestMapping(method = RequestMethod.POST)
    public void doSomething(@ModelAttribute("myModel") MyModel model, SessionStatus status){
       //...
       status.setComplete(); // Clean up the session attribute
    }
    public static void main(String[] args) {
    }
}