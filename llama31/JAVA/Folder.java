import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@NamedQuery(name = "Folder.findEmails", query = "SELECT e.senderName, e.subject, e.sentDate FROM Email e WHERE e.folder = :folder")
public class Folder {
    @OneToMany(mappedBy = "folder")
    private List<Email> emails;

    // Constructor, getters, and setters
    public Folder() {}

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public static void main(String[] args) {
        // Example usage:
        Folder folder = new Folder();
        // Further implementation to persist and retrieve data using JPA
    }

    @Entity
    static class Email {
        private String senderName;
        private String subject;
        private String sentDate;
        @ManyToOne
        @JoinColumn(name = "folder_id")
        private Folder folder;

        // Constructor, getters, and setters
        public Email() {}

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSentDate() {
            return sentDate;
        }

        public void setSentDate(String sentDate) {
            this.sentDate = sentDate;
        }

        public Folder getFolder() {
            return folder;
        }

        public void setFolder(Folder folder) {
            this.folder = folder;
        }
    }
}