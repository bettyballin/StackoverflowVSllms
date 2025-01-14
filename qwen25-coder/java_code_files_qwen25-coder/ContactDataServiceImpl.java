public class ContactDataServiceImpl implements ContactDataService {

    @Override
    public ContactData getContact(int contactId) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new SessionExpiredException("Session expired");
        }
        // Proceed with fetching the contact data
        return fetchContact(contactId);
    }

    private User getCurrentUser() {
        // Implement logic to check session validity and get current user
        return new User();
    }

    private ContactData fetchContact(int contactId) {
        // Fetch contact data from database or other source
        return new ContactData();
    }
}

class SessionExpiredException extends RuntimeException {
    public SessionExpiredException(String message) {
        super(message);
    }
}

class User {
    // User fields and methods
}

class ContactData {
    // ContactData fields and methods
}

interface ContactDataService {
    ContactData getContact(int contactId);
}