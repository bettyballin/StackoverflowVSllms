/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.NamedQuery
 *  javax.persistence.OneToMany
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Folder.findEmails", query="SELECT e.senderName, e.subject, e.sentDate FROM Email e WHERE e.folder = :folder")
public class Folder {
    @OneToMany(mappedBy="folder")
    private List<Email> emails;

    public List<Email> getEmails() {
        return this.emails;
    }

    public void setEmails(List<Email> list) {
        this.emails = list;
    }

    public static void main(String[] stringArray) {
        Folder folder = new Folder();
    }

    @Entity
    static class Email {
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
}
