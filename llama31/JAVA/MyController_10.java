import java.lang.String;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@SessionAttributes(value = "myModel", types = @SessionAttribute(scope = org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))
public class MyController_10_10{
   //...

	public static void main(String[] args) {
	}
}