import java.util.Map;

public class MapContainer {
    private Map<String, String> map; // or private Map<String, DomainClass> map2;
    // getters and setters for both maps

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    // Uncomment the following lines if DomainClass is defined
    /*
    private Map<String, DomainClass> map2;

    public Map<String, DomainClass> getMap2() {
        return map2;
    }

    public void setMap2(Map<String, DomainClass> map2) {
        this.map2 = map2;
    }
    */

    public static void main(String[] args) {
    }
}