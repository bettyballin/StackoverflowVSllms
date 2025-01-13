/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Access
 *  javax.persistence.AccessType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.Id
 */
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(value=AccessType.PROPERTY)
public class Demo {
    private long id;
    private String name;
    private Date created;

    @Id
    public long getId() {
        return this.id;
    }

    public Demo id(long l) {
        this.id = l;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Demo name(String string) {
        this.name = string;
        return this;
    }

    @Column(name="created")
    public Date getCreated() {
        if (this.created == null) {
            this.created = new Date();
        }
        return this.created;
    }

    public Demo created(Date date) {
        this.created = date;
        return this;
    }

    public static void main(String[] stringArray) {
    }
}
