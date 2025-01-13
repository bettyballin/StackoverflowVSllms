/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EntityMetadata {
    @Column(name="LastTouched", insertable=false)
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date lastTouched;

    public static void main(String[] stringArray) {
    }
}
