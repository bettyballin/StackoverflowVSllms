/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class LicenseorSubscription {
    @Column(name="activationDate")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Calendar activationDate;

    public static void main(String[] stringArray) {
    }
}
