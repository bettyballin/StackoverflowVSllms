import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(AccessType.PROPERTY)
public class Demo {
    private long id;
    private String name;
    private Date created;

    @Id
    public long getId() { return id; }
    public Demo id(long value) { id = value; return this; }

    public String getName() { return name; }
    public Demo name(String value) { name = value; return this; }

    @Column(name = "created")
    public Date getCreated() { 
        if (created == null) created = new Date();
        return created; 
    }
    public Demo created(Date value) { created = value; return this; }

    public static void main(String[] args) {
    }
}