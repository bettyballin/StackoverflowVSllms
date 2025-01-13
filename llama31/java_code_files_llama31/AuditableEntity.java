/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.PrePersist
 */
import java.util.Date;
import javax.persistence.PrePersist;

public class AuditableEntity {
    private Date created;

    @PrePersist
    public void prePersist() {
        if (this.created == null) {
            this.created = new Date();
        }
    }

    public static void main(String[] stringArray) {
    }
}
