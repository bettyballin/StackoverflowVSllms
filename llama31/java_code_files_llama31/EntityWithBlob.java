/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.ElementCollection
 *  javax.persistence.FetchType
 *  javax.persistence.Lob
 */
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class EntityWithBlob {
    @ElementCollection(fetch=FetchType.EAGER)
    @Lob
    @Column(name="BLOB_COLUMN")
    private byte[] blob;

    public static void main(String[] stringArray) {
    }
}
