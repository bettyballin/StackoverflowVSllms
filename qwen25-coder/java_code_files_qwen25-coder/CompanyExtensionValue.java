import javax.persistence.*;

@Entity
public class CompanyExtensionValue {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name="company_id")
   private Company company;

   @ManyToOne
   @JoinColumn(name="extension_id")
   private CompanyExtension extension;

   private String value; // Store all values as strings and convert them as needed in application logic.

   public static void main(String[] args) {
   }
}

class Company {
   // Empty class
}

class CompanyExtension {
   // Empty class
}