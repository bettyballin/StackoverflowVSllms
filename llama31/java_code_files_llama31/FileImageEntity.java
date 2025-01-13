/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Lob
 */
import javax.persistence.Column;
import javax.persistence.Lob;

public class FileImageEntity {
    @Column(name="FILEIMAGE")
    @Lob
    private byte[] fileimage;

    public byte[] getFileimage() {
        return this.fileimage;
    }

    public void setFileimage(byte[] byArray) {
        this.fileimage = byArray;
    }

    public static void main(String[] stringArray) {
    }
}
