/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EntityWithDate {
    @Temporal(value=TemporalType.DATE)
    private Date myDate;

    public static void main(String[] stringArray) {
    }
}
