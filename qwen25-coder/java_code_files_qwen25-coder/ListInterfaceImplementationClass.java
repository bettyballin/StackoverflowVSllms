import java.util.List;
import java.util.ArrayList;

public class ListInterfaceImplementationClass {
    List<MyCustomClass> listCustClass = new ArrayList<MyCustomClass>(); // Use an implementation class
    
    public ListInterfaceImplementationClass() {
        listCustClass = GetList();
    }
    
    public List<MyCustomClass> GetList() {
        // Implement the method to return a List<MyCustomClass>
        return new ArrayList<MyCustomClass>();
    }
    
    public static void main(String[] args) {
    }
}