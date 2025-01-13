import java.lang.String;
import javax.jws.WebService;
import javax.xml.ws.PolicySet;
import javax.xml.ws.PolicySets;

@WebService
@PolicySets({
  @PolicySet(name = "Kerberos", enabled = true)
})
public class MyService_19_19 {
  // service methods

	public static void main(String[] args) {
	}
}