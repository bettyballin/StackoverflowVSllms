public class ServiceFacadeImpl {
    private ContactDAO contactDao;
    private PortalService portalService;
    
    void createPortalAccount(Contact contact) { // This is a facade method, the purpose of which is to coordinate actions across services.
        User newUser = this.portalService.createRemoteUser(contact); // Here you're creating a remote user in another service.
        contact.setPortalAccount(newUser.getId(), newUser.getUsername()); // Update Contact with the newly created portal account information, returned by createRemoteUser method.
        this.contactDao.save(contact);  // Persist changes to Contact. This is a separate operation from creating a remote user and could happen regardless of if the user was successfully created remotely or not.
    }
}

class PortalServiceImpl implements PortalService {
    public User createRemoteUser(Contact contact) { // Here you are only responsible for creating a new portal account on a remote system, this has nothing to do with database operations which belong in DAOs.
        // Implementation code
        return new User();
    }
}

interface PortalService {
    User createRemoteUser(Contact contact);
}

interface ContactDAO {
    void save(Contact contact);
}

class User {
    public int getId() {
        return 0;
    }

    public String getUsername() {
        return "";
    }
}

class Contact {
    public void setPortalAccount(int id, String username) {
        // Implementation code
    }
}