import java.util.Comparator;

class Contact {
    private String contactFirstName;
    private String contactLastName;

    public String get_contactFirstName() {
        return contactFirstName;
    }

    public void set_contactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String get_contactLastName() {
        return contactLastName;
    }

    public void set_contactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }
}

public class ContactsListComparator {
    public static class ContactsListComparatorImpl implements Comparator<Contact> {
        public int compare(Contact o1, Contact o2) {
            int result = o1.get_contactFirstName().compareTo(o2.get_contactFirstName());
            if (result == 0) {
                result = o1.get_contactLastName().compareTo(o2.get_contactLastName());
            }
            return result;
        }
    }

    public static void main(String[] args) {
    }
}