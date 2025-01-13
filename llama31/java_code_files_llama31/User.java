/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.Id
 */
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class User {
    @Id
    private Long id;
    private String name;

    public User() {
    }

    public User(Long l, String string) {
        this.id = l;
        this.name = string;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }
}
