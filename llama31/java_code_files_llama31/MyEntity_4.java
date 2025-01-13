/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.Id
 */
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity_4 {
    @Id
    @Column(columnDefinition="BINARY(16)")
    private UUID id;

    public static void main(String[] stringArray) {
    }
}
