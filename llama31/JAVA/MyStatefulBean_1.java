import javax.ejb.Stateful;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;

@Stateful
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MyStatefulBean_1_1 {
    // ...

    public static void main(String[] args) {
    }
}