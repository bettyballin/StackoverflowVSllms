/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.PrePersist
 *  javax.persistence.PreUpdate
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntityClass {
    @Column(name="LastTouched")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date lastTouched;

    @PrePersist
    @PreUpdate
    public void setLastTouched() {
        this.lastTouched = new Date();
    }
}
