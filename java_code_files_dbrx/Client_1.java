import java.lang.String;
import org.omg.CORBA.ORB;

public class Client_1 {
  public static void main(String args[]) throws Exception {
    ORB orb = ORB.init(args, null);
    BookDB bbdref = (BookDB)orb.resolve_initial_references("bookdb");   // resolve the reference of service
    String title = bbdref.getTitle(1234567890);                        // remote method invocation !
  }
}

interface BookDB {
    String getTitle(int isbn);
}