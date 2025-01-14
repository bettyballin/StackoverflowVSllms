import java.lang.String;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ContactManager {

    private List<ApplContactDtl> contactsList;

    public ContactManager() {
        contactsList = new ArrayList<ApplContactDtl>();
    }

    public void deleteContact(Long contactId) {
        for (Iterator<ApplContactDtl> iterator = contactsList.iterator(); iterator.hasNext();) {
            ApplContactDtl contact = iterator.next();
            if (contact.getId().equals(contactId)) {
                // Perform database deletion here
                deleteFromDatabase(contact);
                
                // Remove the contact from the list
                iterator.remove();
                break;
            }
        }
        
        // Perform any other actions you need to update the ApplNotifBean state after removal
    }
    
    private void deleteFromDatabase(ApplContactDtl contact) {
        // Implementation of database deletion for the given contact
        // This can involve using a DAO or repository pattern, etc.
    }
    
    public static void main(String[] args) {
        // Sample usage
        ContactManager manager = new ContactManager();
        manager.deleteContact(1L);
    }
}

class ApplContactDtl {
    private Long id;

    public ApplContactDtl(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}