import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.MapKeyColumn;
import javax.persistence.Column;

public class ConfigurationItem {
    @ElementCollection
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> myMap;

    public static void main(String[] args) {
    }
}