import java.lang.String;

interface PortalService {
    void createRemotePortalAccountForContact(Contact contact) throws Exception;
}

class Contact {
    private String portalUserId;
    private String portalUsername;
    
    public void setPortalUserId(String userId) {
        this.portalUserId = userId;
    }
    
    public void setPortalUsername(String username) {
        this.portalUsername = username;
    }
}

class ContactDAO {
    public void save(Contact contact) {
        // Save logic here
    }
}

public class PortalServiceImpl implements PortalService {
    public void createRemotePortalAccountForContact(Contact contact) throws Exception {
        // Create the remote user on the portal and get necessary data back
        String userId = createRemoteUser(contact); // Implement this method to interact with SOAP/AXIS
        String username = getUsernameFromResponse(); // Assuming you need to parse this from response
        
        // Update the Contact object as needed
        contact.setPortalUserId(userId);
        contact.setPortalUsername(username);
    }

    private String createRemoteUser(Contact contact) {
        // SOAP call logic here...
        return "mockedUserId"; // Replace with actual SOAP response parsing logic
    }
    
    private String getUsernameFromResponse() {
        // Logic to get username from SOAP response...
        return "mockedUsername";
    }
    
    public static void main(String[] args) {
        // Entry point
    }
}

class ServiceFacadeImpl {
    private PortalService portalService = new PortalServiceImpl();
    private ContactDAO contactDAO = new ContactDAO();

    public void createPortalAccount(Contact contact) throws Exception {
        portalService.createRemotePortalAccountForContact(contact);
        contactDAO.save(contact); // This is where your transaction should be wrapping
    }
}