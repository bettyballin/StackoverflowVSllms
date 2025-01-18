import java.util.Date;

@interface EntityListeners {
    Class<?>[] value();
}

@interface CreatedDate {}

@interface PrePersist {}

class AuditingEntityListener {}

@EntityListeners(AuditingEntityListener.class)
public class Demo {
    private Long id;
    private String name;
    @CreatedDate   // This annotation marks the field as created_at date-time (with JSR303 bean validation)
    private Date created;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist       // Executed before persisting into DB
    public void prePersist() {
        if(created == null){
            created = new Date();   // Automatically insert a Created_at time at the creation of object.
        }
    }
}