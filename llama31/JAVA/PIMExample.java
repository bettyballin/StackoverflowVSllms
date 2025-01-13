import java.lang.String;
// Example of using PIM package in Java
import net.rim.blackberry.api.pdap.PIM;
import net.rim.blackberry.api.pdap.ContactList;

public class PIMExample
{
    public void syncContacts()
    {
        PIM pim = PIM.getInstance();
        ContactList contacts = (ContactList)pim.openPIMList(PIM.CONTACT_LIST, PIM.READ_ONLY);
        // Process the contacts
        contacts.close();
    }

    public static void main(String[] args) {
        PIMExample example = new PIMExample();
        example.syncContacts();
    }
}