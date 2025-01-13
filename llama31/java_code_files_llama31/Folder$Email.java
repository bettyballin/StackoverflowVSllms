/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 */
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
static class Folder.Email {
    private String senderName;
    private String subject;
    private String sentDate;
    @ManyToOne
    @JoinColumn(name="folder_id")
    private Folder folder;

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String string) {
        this.senderName = string;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String string) {
        this.subject = string;
    }

    public String getSentDate() {
        return this.sentDate;
    }

    public void setSentDate(String string) {
        this.sentDate = string;
    }

    public Folder getFolder() {
        return this.folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
