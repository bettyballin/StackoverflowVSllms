import java.util.Map;
  
public class DomainClass {
    private String property1;
    private int property2;

    // Getters and setters

    private Map<String, DomainClass> myObjectMap;

    public Map<String, DomainClass> getMyObjectMap() { return myObjectMap; }

    public void setMyObjectMap(Map<String, DomainClass> myObjectMap) { 
        this.myObjectMap = myObjectMap; 
    }

    public static void main(String[] args) {
    }
}