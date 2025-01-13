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
class MyEntity {
    @Id
    private Long id;

    MyEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }
}
