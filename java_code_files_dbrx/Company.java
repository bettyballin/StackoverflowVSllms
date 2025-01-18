import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;

@Entity
public class Company {
  // ... other fields
  @ElementCollection
  @CollectionTable(name = "company_additional_properties", joinColumns = @JoinColumn(name = "company_id"))
  private Map<String, Object> additionalProperties = new HashMap<>();

    public static void main(String[] args) {
    }
}