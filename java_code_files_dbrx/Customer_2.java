// Dummy annotation definitions to make the code compile
@interface Audited {
}

@interface AuditTable {
}

@interface Entity {
}

@interface Table {
    String name();
}

@interface Id {
}

// Actual code
@Entity
@Audited
public class Customer {

    @Id
    private Integer id;

    // other fields and methods here...

    public Customer() {
    }

    // Getters and setters for 'id'
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // You can add other fields and methods as needed
}

// And for the audit table, map this entity:

@Entity
@Table(name = "customer_aud")  // or a more descriptive name if you like
class CustomerAud {

    @Id
    private Integer id;

    // other fields and methods here...

    public CustomerAud() {
    }

    // Getters and setters for 'id'
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // You can add other fields and methods as needed
}