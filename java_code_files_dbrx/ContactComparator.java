import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {
    // assuming _contactFirstName_ fields have non-null & non-empty values for all objects.
    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1._contactFirstName != null && o2._contactFirstName != null) {
            return o1._contactFirstName.compareToIgnoreCase(o2._contactFirstName); // ignore case for consistent order
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else {
            throw new IllegalArgumentException("At least one contact has no first name!");
        }
    }
}

class Contact {
    public String _contactFirstName;

    public Contact(String firstName) {
        this._contactFirstName = firstName;
    }
}